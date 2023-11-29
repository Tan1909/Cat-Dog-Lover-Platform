package Group6.SWP301.repository;

import Group6.SWP301.Entity.RequestPetExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface requestPetExchangeRepository extends JpaRepository<RequestPetExchange,Integer> {

    List<RequestPetExchange> findAllByStatusFalse();


}
