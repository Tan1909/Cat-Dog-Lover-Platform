package Group6.SWP301.repository;

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.Entity.Item;
import Group6.SWP301.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface itemRepository extends JpaRepository<Item,Integer> {

    @Query("SELECT b FROM Item b WHERE b.userid =:id")
    List<Item> findByUserid(@Param("id") UserAccount id);
}
