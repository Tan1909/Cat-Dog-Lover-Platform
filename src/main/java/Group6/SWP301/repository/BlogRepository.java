package Group6.SWP301.repository;

import Group6.SWP301.Entity.Blogs;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blogs, Integer> {

        List<Blogs> findAllByStatusTrue();

        @Query("SELECT b FROM Blogs b WHERE b.title LIKE %:title%")
        List<Blogs> searchByTitle(@Param("title") String title);

        @Query("SELECT b FROM Blogs b WHERE b.title LIKE %:title% AND b.description LIKE %:description% AND b.blogcontent LIKE %:blogcontent%"
                        + " AND b.reasondeny LIKE %:reasondeny% AND (:status IS NULL OR b.status = :status)"
                        + " AND (:dateCreateStart IS NULL OR b.datecreate >= :dateCreateStart)"
                        + " AND (:dateCreateEnd IS NULL OR b.datecreate <= :dateCreateEnd)")
        List<Blogs> getListBlog(@Param("title") String title, @Param("description") String description,
                        @Param("blogcontent") String blogcontent, @Param("reasondeny") String reasondeny,
                        @Param("status") Boolean status, @Param("dateCreateStart") Date dateCreateStart,
                        @Param("dateCreateEnd") Date dateCreateEnd, Pageable pageable);
}
