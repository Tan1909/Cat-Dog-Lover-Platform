package Group6.SWP301.service;/*  Welcome to Jio word
                              @author: Jio
                              Date: 10/9/2023
                              Time: 3:13 PM
                              
                              ProjectName: SWP301
                              Jio: I wish you always happy with coding <3
                              */

import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.model.dto.request.UserDTORequest;
import Group6.SWP301.model.dto.response.UserDTOResponse;
import Group6.SWP301.model.enumclass.EnumClass.SortMemberBy;
import Group6.SWP301.model.enumclass.EnumClass.SortType;

import java.util.Date;
import java.util.List;

public interface IUserService {
    List<UserAccount> getAllStaff();

    UserDTOResponse updateUser(UserDTORequest userDTORequest, int userId);

    UserDTOResponse deleteStaff(int userId);

    UserDTOResponse login(String gmail, String pass);

    boolean signinForUser(UserDTORequest userDTORequest);

    UserDTOResponse profile(int id);

    boolean editProfile(UserDTORequest userDTORequest, int id);

    List<UserAccount> getListMember(String code, String name, String gmail, String address, String phone, Boolean sex,
            Boolean status, Date dobStart, Date dobEnd, int pageNumber, int pageSize, SortMemberBy sortBy, SortType sortType);

    boolean changeStatus(int userId);
}
