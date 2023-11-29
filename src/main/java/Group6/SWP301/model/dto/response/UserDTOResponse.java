package Group6.SWP301.model.dto.response;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 4:17 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import lombok.*;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOResponse {
    private int Userid;
    private String code;
    private String name;
    private String gmail;
    private String address;
    private String phone;
    private boolean sex;
    private Date dob;

    private String role;
}
