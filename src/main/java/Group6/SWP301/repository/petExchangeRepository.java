package Group6.SWP301.repository;

import Group6.SWP301.Entity.PetExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface petExchangeRepository extends JpaRepository<PetExchange,Integer> {



}
