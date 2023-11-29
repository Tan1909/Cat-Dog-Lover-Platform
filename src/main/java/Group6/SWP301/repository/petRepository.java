package Group6.SWP301.repository;

import Group6.SWP301.Entity.Blogs;
import Group6.SWP301.Entity.Pet;
import Group6.SWP301.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface petRepository extends JpaRepository<Pet,Integer> {
    @Query("SELECT b FROM Pet b WHERE b.user =:id")
    List<Pet> findByUser(@Param("id") UserAccount id);

    @Query("SELECT b FROM Pet b WHERE b.PetID =:id")
    Pet findByPetID(@Param("id") int id);
}
