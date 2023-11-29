package Group6.SWP301.service.impl;/*  Welcome to Jio word
                                   @author: Jio
                                   Date: 10/9/2023
                                   Time: 3:22 PM
                                   
                                   ProjectName: SWP301
                                   Jio: I wish you always happy with coding <3
                                   */

import Group6.SWP301.Entity.BlogCategory;
import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.model.dto.request.BlogDTORequest;
import Group6.SWP301.model.dto.response.BlogDTOResponse;
import Group6.SWP301.model.enumclass.EnumClass.SortBlogBy;
import Group6.SWP301.model.enumclass.EnumClass.SortType;
import Group6.SWP301.model.mapper.BlogMapper;
import Group6.SWP301.repository.BlogRepository;
import Group6.SWP301.repository.UseraccountRepository;
import Group6.SWP301.repository.blogcategoryRepository;
import Group6.SWP301.service.IBlogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogServiceImpl implements IBlogService {

    private BlogRepository blogRepository;
    private UseraccountRepository userRepository;
    @Autowired
    private blogcategoryRepository blogcategoryRepository;

    @Override
    public List<Blogs> getAllBlog() {

        return blogRepository.findAllByStatusTrue();
    }

    @Override
    @Transactional
    public BlogDTOResponse deleteById(int blogId) {
        Blogs blogEntity = blogRepository.findById(blogId)
                .orElseThrow(() -> new IllegalStateException(
                        "blog with id " + blogId + " does not exist!"));

        blogEntity.setStatus(false);

        return BlogMapper.toBlogResponse(blogEntity);
    }

    @Override
    public List<Blogs> searchByTitle(String title) {
        return blogRepository.searchByTitle(title);
    }

    @Override
    public boolean createBlog(BlogDTORequest blogDTORequest, int id) {

        UserAccount userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + id + " does not exist!"));

        Blogs blog = new Blogs();
        blog = BlogMapper.toBlogEntity(blogDTORequest);
        blog.setUserid(userEntity);
        Date date = new Date();
        blog.setDatecreate(date);
        blog.setDateupdate(date);
        BlogCategory blogCategory = blogcategoryRepository.findByBlogcategoryid(blogDTORequest.getBlogidcategory());
        blog.setBlogcategoryid(blogCategory);
        try {
            blogRepository.save(blog);

        } catch (Exception e) {
            System.out.println("lỗi thêm Blog :" + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Blogs> getListBlog(String title, String description, String blogcontent, String reasondeny,
            Boolean status, Date dateCreateStart, Date dateCreateEnd, int pageNumber, int pageSize, SortBlogBy sortBy,
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
        return blogRepository.getListBlog(title, description, blogcontent, reasondeny, status, dateCreateStart,
                dateCreateEnd, pageable);
    }

    @Override
    public boolean changeStatus(int blogId, boolean status, String reasondeny) {
        Blogs blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new IllegalStateException(
                        "Blog with id " + blogId + " does not exist!"));
        blog.setStatus(status);
        if (!status) {
            blog.setReasondeny(reasondeny);
        }
        try {
            blogRepository.save(blog);
        } catch (Exception E) {
            System.out.println("lỗi ban/unban blog :" + E.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
