package Group6.SWP301.model.dto.request;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 4:58 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTORequest {
    private String code;
    private String name;
    private String gmail;
    private String pass;
    private String address;
    private String phone;
    private Boolean sex;
    private Date dob;
    private String img;
    private String role;
}
