package Group6.SWP301.model.mapper;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 4:21 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.repository.roleRepository;
import Group6.SWP301.model.dto.request.UserDTORequest;
import Group6.SWP301.model.dto.response.UserDTOResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserMapper {

    private final roleRepository roleRepository;

    @Autowired
    public UserMapper(Group6.SWP301.repository.roleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public static UserDTOResponse toUserResponse(UserAccount userAccount) {
        UserDTOResponse userDTOResponse = new UserDTOResponse();
        BeanUtils.copyProperties(userAccount, userDTOResponse);
        userDTOResponse.setRole(userAccount.getRolesid().getRolename());
        return userDTOResponse;
    }

    public static List<UserDTOResponse> toListUserResponse(List<UserAccount> userAccounts) {
        List<UserDTOResponse> userDTOResponses = new ArrayList<>();
        for (UserAccount userAccount : userAccounts) {
            userDTOResponses.add(toUserResponse(userAccount));
        }
        return userDTOResponses;
    }

    public static UserAccount toUserEntity(UserDTORequest userDTORequest, UserAccount userEntity) {


        if (userDTORequest.getCode() != null &&
                userDTORequest.getCode().length() > 0 &&
                !Objects.equals(userEntity.getCode(), userDTORequest.getCode())) {

            userEntity.setName(userDTORequest.getCode() );
        }

        if (userDTORequest.getName() != null &&
                userDTORequest.getName().length() > 0 &&
                !Objects.equals(userEntity.getName(), userDTORequest.getName() )) {

            userEntity.setName(userDTORequest.getName() );
        }

        if (userDTORequest.getGmail() != null &&
                userDTORequest.getGmail().length() > 0 &&
                !Objects.equals(userEntity.getGmail(), userDTORequest.getGmail() )) {

            userEntity.setGmail(userDTORequest.getGmail() );
        }

        if (userDTORequest.getAddress() != null &&
                userDTORequest.getAddress().length() > 0 &&
                !Objects.equals(userEntity.getAddress(), userDTORequest.getAddress() )) {

            userEntity.setAddress(userDTORequest.getAddress() );
        }

        if (userDTORequest.getPhone() != null &&
                userDTORequest.getPhone().length() > 0 &&
                !Objects.equals(userEntity.getPhone(), userDTORequest.getPhone() )) {

            userEntity.setPhone(userDTORequest.getPhone() );
        }

        if (userDTORequest.getSex() != null &&
                !Objects.equals(userEntity.isSex(),  userDTORequest.getSex() )) {

            userEntity.setSex(userDTORequest.getSex() );
        }

        if (userDTORequest.getDob() != null &&
                !Objects.equals(userEntity.getDob(), userDTORequest.getDob() )) {

            userEntity.setDob(userDTORequest.getDob() );}

            if (userDTORequest.getCode() != null &&
                    !Objects.equals(userEntity.getCode(), userDTORequest.getCode() )) {

                userEntity.setCode(userDTORequest.getCode());
        }
        if (userDTORequest.getPass() != null &&
                !Objects.equals(userEntity.getPassword(), userDTORequest.getPass() )) {

            userEntity.setPassword(userDTORequest.getPass());
        }
        if (userDTORequest.getImg() != null &&
                !Objects.equals(userEntity.getImage(), userDTORequest.getImg() )) {

            userEntity.setImage(userDTORequest.getImg());
        }


        return userEntity;
        }
    }






