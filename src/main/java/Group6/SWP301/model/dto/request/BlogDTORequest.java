package Group6.SWP301.model.dto.request;

import Group6.SWP301.Entity.BlogCategory;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDTORequest {
    private int blogid;
    private String title;
    private String description;
    private String blogcontent;
    private Date datecreate;
    private Date dateupdate;
    private boolean status;
    private int blogidcategory;
    private String reasondeny;
    private String react;
}
