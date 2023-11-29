package Group6.SWP301.model.mapper;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 7:01 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.model.dto.request.BlogDTORequest;
import Group6.SWP301.model.dto.response.BlogDTOResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BlogMapper {
    // Blog
    public static BlogDTOResponse toBlogResponse(Blogs blogEntity) {
        BlogDTOResponse blogDTOResponse = new BlogDTOResponse();
        BeanUtils.copyProperties(blogEntity, blogDTOResponse);
        return blogDTOResponse;
    }

    public static List<BlogDTOResponse> toListBlogResponse(List<Blogs> blogs) {
        List<BlogDTOResponse> blogDTOResponses = new ArrayList<>();
        for (Blogs blog : blogs) {
            blogDTOResponses.add(toBlogResponse(blog));
        }
        return blogDTOResponses;
    }

    public static Blogs toBlogEntity (BlogDTORequest blogDTORequest){
Blogs blogs = new Blogs();

BeanUtils.copyProperties(blogDTORequest, blogs);
return blogs;

    }
}
