package Group6.SWP301.model.dto.response;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 6:43 PM
    
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
public class BlogDTOResponse {
    private int blogid;
    private String title;
    private String description;
    private String blogcontent;
    private Date datecreate;
    private Date dateupdate;
    private boolean status;
    private String reasondeny;
    private String react;
}
