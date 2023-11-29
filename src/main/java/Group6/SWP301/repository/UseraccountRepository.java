package Group6.SWP301.repository;

import Group6.SWP301.Entity.UserAccount;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UseraccountRepository extends JpaRepository<UserAccount, Integer> {
        List<UserAccount> findAllByStatusTrueAndRolesid_Rolename(String roleName);

        UserAccount findByGmailAndPassword(String gmail, String password);

        @Query("SELECT u FROM UserAccount u WHERE u.code LIKE %:code% AND u.name LIKE %:name% AND u.gmail LIKE %:gmail%"
                        + " AND u.address LIKE %:address% AND u.phone LIKE %:phone% AND u.rolesid.roleid = 3"
                        + " AND (:dobStart IS NULL OR u.dob >= :dobStart) AND (:dobEnd IS NULL OR u.dob <= :dobEnd)"
                        + " AND (:sex IS NULL OR u.sex = :sex) AND (:status IS NULL OR u.status = :status)")
        List<UserAccount> getListMember(@Param("code") String code, @Param("name") String name,
                        @Param("gmail") String gmail, @Param("address") String address, @Param("phone") String phone,
                        @Param("sex") Boolean sex, @Param("status") Boolean status, @Param("dobStart") Date dobStart,
                        @Param("dobEnd") Date dobEnd, Pageable pageable);
}