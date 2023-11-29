package Group6.SWP301.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.model.enumclass.EnumClass.SortBlogBy;
import Group6.SWP301.model.enumclass.EnumClass.SortMemberBy;
import Group6.SWP301.model.enumclass.EnumClass.SortType;
import Group6.SWP301.model.mapper.BlogMapper;
import Group6.SWP301.model.mapper.UserMapper;
import Group6.SWP301.service.IBlogService;
import Group6.SWP301.service.IUserService;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    IUserService userService;

    @Autowired
    IBlogService blogService;

    @GetMapping("/member")
    public ResponseEntity<?> getListMember(@RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String gmail,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "") String sex,
            @RequestParam(required = false, defaultValue = "") String status,
            @RequestParam(required = false, name = "dobStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dobStart,
            @RequestParam(required = false, name = "dobEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dobEnd,
            @RequestParam(name = "sortBy", required = false) SortMemberBy sortBy,
            @RequestParam(name = "sortType", required = false) SortType sortType,
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Boolean sexValue = null;
        if (sex.equals("1")) {
            sexValue = true;
        } else if (sex.equals("0")) {
            sexValue = false;
        }

        Boolean statusValue = null;
        if (status.equals("1")) {
            statusValue = true;
        } else if (status.equals("0")) {
            statusValue = false;
        }

        List<UserAccount> userMember = userService.getListMember(code, name, gmail, address, phone, sexValue,
                statusValue, dobStart, dobEnd, pageNumber, pageSize, sortBy, sortType);
        return new ResponseEntity<>(UserMapper.toListUserResponse(userMember), HttpStatus.OK);
    }

    @PutMapping(path = "/member/{userId}")
    private ResponseEntity<?> changeStatusMember(@PathVariable("userId") int userId) {
        boolean check = userService.changeStatus(userId);
        if (check) {
            return new ResponseEntity<>("sửa thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("sửa thất bại", HttpStatus.OK);
        }
    }

    @GetMapping("/blog")
    public ResponseEntity<?> getListBlog(@RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String blogcontent,
            @RequestParam(required = false, defaultValue = "") String reasondeny,
            @RequestParam(required = false, defaultValue = "") String status,
            @RequestParam(required = false, name = "dateCreateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateCreateStart,
            @RequestParam(required = false, name = "dateCreateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateCreateEnd,
            @RequestParam(name = "sortBy", required = false) SortBlogBy sortBy,
            @RequestParam(name = "sortType", required = false) SortType sortType,
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Boolean statusValue = null;
        if (status.equals("1")) {
            statusValue = true;
        } else if (status.equals("0")) {
            statusValue = false;
        }
        List<Blogs> blogs = blogService.getListBlog(title, description, blogcontent, reasondeny, statusValue,
                dateCreateStart, dateCreateEnd, pageNumber, pageSize, sortBy, sortType);
        return new ResponseEntity<>(BlogMapper.toListBlogResponse(blogs), HttpStatus.OK);
    }

    @PutMapping(path = "/blog/{blogId}")
    private ResponseEntity<?> changeStatusBlog(@PathVariable("blogId") int blogId,
            @RequestParam boolean status,
            @RequestParam(required = false, defaultValue = "") String reasondeny) {
        boolean check = blogService.changeStatus(blogId, status, reasondeny);
        if (check) {
            return new ResponseEntity<>("ban/unban blog thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ban/unban blog thất bại", HttpStatus.OK);
        }
    }
}
