package Group6.SWP301.repository;

import Group6.SWP301.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepository extends JpaRepository<Roles,Integer> {

    Roles findByRolename(String name);
}
