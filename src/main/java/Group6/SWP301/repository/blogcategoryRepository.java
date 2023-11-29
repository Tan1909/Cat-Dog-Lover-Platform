package Group6.SWP301.repository;

import Group6.SWP301.Entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface blogcategoryRepository extends JpaRepository<BlogCategory,Integer> {
BlogCategory findByBlogcategoryid(int id);

}
