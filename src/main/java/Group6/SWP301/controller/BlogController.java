package Group6.SWP301.controller;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 6:21 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.model.dto.request.BlogDTORequest;
import Group6.SWP301.model.dto.response.BlogDTOResponse;
import Group6.SWP301.model.mapper.BlogMapper;
import Group6.SWP301.service.IBlogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class BlogController {
    @Autowired
    IBlogService blogService;

   // get all and search
    // http://localhost:8080/api/v1/blogs?title=chi
    // http://localhost:8080/api/v1/blogs
    @GetMapping()
    public ResponseEntity<?> getAllAndSearchBlog(@RequestParam(required = false) String title){
        List<Blogs> blogs = null;

        if(title != null &&
        title.length() > 0){
            blogs = blogService.searchByTitle(title);
        }else {

            blogs  = blogService.getAllBlog();

        }


        return new ResponseEntity<>(BlogMapper.toListBlogResponse(blogs), HttpStatus.OK);

    }

    @DeleteMapping("{blogId}")
    ResponseEntity<?> deleteBlog(@PathVariable("blogId") int blogId){

        BlogDTOResponse blogDTOResponse = blogService.deleteById(blogId);

        return new ResponseEntity<>(blogDTOResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<?> createBlog(@RequestBody BlogDTORequest blogDTORequest, int id){
    boolean a = blogService.createBlog(blogDTORequest,id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
}
