package Group6.SWP301.repository;

import Group6.SWP301.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository<Comments,Integer> {
}
