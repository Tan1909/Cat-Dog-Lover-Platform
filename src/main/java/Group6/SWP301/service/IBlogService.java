package Group6.SWP301.service;/*  Welcome to Jio word
                              @author: Jio
                              Date: 10/9/2023
                              Time: 3:20 PM
                              
                              ProjectName: SWP301
                              Jio: I wish you always happy with coding <3
                              */

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.model.dto.request.BlogDTORequest;
import Group6.SWP301.model.dto.response.BlogDTOResponse;
import Group6.SWP301.model.enumclass.EnumClass.SortBlogBy;
import Group6.SWP301.model.enumclass.EnumClass.SortType;

import java.util.Date;
import java.util.List;

public interface IBlogService {
    List<Blogs> getAllBlog();

    BlogDTOResponse deleteById(int blogId);

    List<Blogs> searchByTitle(String title);

    boolean createBlog(BlogDTORequest blogDTORequest, int id);

    List<Blogs> getListBlog(String title, String description, String blogcontent, String reasondeny, Boolean status,
            Date dateCreateStart, Date dateCreateEnd, int pageNumber, int pageSize, SortBlogBy sortBy, SortType sortType);

    boolean changeStatus(int blogId, boolean status, String reasondeny);
}
