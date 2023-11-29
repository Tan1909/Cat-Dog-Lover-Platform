package Group6.SWP301.service.impl;
/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 3:14 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import Group6.SWP301.Entity.Roles;
import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.repository.roleRepository;
import Group6.SWP301.repository.UseraccountRepository;
import Group6.SWP301.model.dto.request.UserDTORequest;
import Group6.SWP301.model.dto.response.UserDTOResponse;
import Group6.SWP301.model.enumclass.EnumClass.SortMemberBy;
import Group6.SWP301.model.enumclass.EnumClass.SortType;
import Group6.SWP301.model.mapper.UserMapper;
import Group6.SWP301.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    private final UseraccountRepository userRepository;
    private final roleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UseraccountRepository userRepository,
            Group6.SWP301.repository.roleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserAccount> getAllStaff() {
        return userRepository.findAllByStatusTrueAndRolesid_Rolename("Staff");
    }

    @Override
    @Transactional
    public UserDTOResponse updateUser(UserDTORequest userDTORequest, int userId) {

        UserAccount userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exist!"));

        userEntity = UserMapper.toUserEntity(userDTORequest, userEntity);

        if (userDTORequest.getRole() != null &&
                userDTORequest.getRole().length() > 0 &&
                !Objects.equals(userEntity.getCode(), userDTORequest.getCode())) {
            Roles usRoles = roleRepository.findByRolename(userDTORequest.getRole());
            userEntity.setRolesid(usRoles);
        }

        UserDTOResponse userDTOResponse = UserMapper.toUserResponse(userEntity);
        return userDTOResponse;
    }

    @Override
    @Transactional
    public UserDTOResponse deleteStaff(int userId) {
        UserAccount userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exist!"));
        Roles usRoles = roleRepository.findByRolename("User");
        userEntity.setRolesid(usRoles);
        return UserMapper.toUserResponse(userEntity);
    }

    @Override
    public UserDTOResponse login(String gmail, String pass) {
        UserAccount us = userRepository.findByGmailAndPassword(gmail, pass);

        return UserMapper.toUserResponse(us);

    }

    @Override
    public boolean signinForUser(UserDTORequest userDTORequest) {

        UserAccount userAccount = new UserAccount();
        Roles roles = new Roles();
        roles.setRoleid(3);
        userAccount.setRolesid(roles);
        userAccount.setGmail(userDTORequest.getGmail());
        userAccount.setPassword(userDTORequest.getPass());
        try {
            userRepository.save(userAccount);
        } catch (Exception E) {
            System.out.println("lỗi đăng kí thêm user :" + E.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public UserDTOResponse profile(int id) {

        UserAccount userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + id + " does not exist!"));

        UserDTOResponse userDTOResponse = UserMapper.toUserResponse(userEntity);
        return userDTOResponse;
    }

    @Override
    public boolean editProfile(UserDTORequest userDTORequest, int id) {

        UserAccount userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + id + " does not exist!"));
        UserAccount user = new UserAccount();
        user = UserMapper.toUserEntity(userDTORequest, user);
        user.setUserid(id);
        user.setDatecreate(userEntity.getDatecreate());
        Date date = new Date();

        user.setDateupdate(date);
        user.setStatus(true);

        user.setRolesid(userEntity.getRolesid());


        try {
            userRepository.save(user);
        } catch (Exception E) {
            System.out.println("lỗi sửa thông tin user :" + E.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<UserAccount> getListMember(String code, String name, String gmail, String address, String phone,
            Boolean sex, Boolean status, Date dobStart, Date dobEnd, int pageNumber, int pageSize, SortMemberBy sortBy,
            SortType sortType) {
        Pageable pageable;
        if (sortBy != null) {
            Sort sort = null;
            if(sortType != null && sortType.equals(SortType.DESC)) {
                sort = Sort.by(sortBy.toString()).descending();
            } else {
                sort = Sort.by(sortBy.toString()).ascending();
            }
            pageable = PageRequest.of(pageNumber, pageSize, sort);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return userRepository.getListMember(code, name, gmail, address, phone, sex, status, dobStart, dobEnd, pageable);
    }

    @Override
    public boolean changeStatus(int userId) {
        UserAccount user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exist!"));

        if (user.getRolesid().getRoleid() == 3) {
            user.setStatus(!user.isStatus());
        }

        try {
            userRepository.save(user);
        } catch (Exception E) {
            System.out.println("lỗi ban/unban user :" + E.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
