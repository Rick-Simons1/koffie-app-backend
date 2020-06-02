package koffieApp.repository;

import koffieApp.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeQueryRepository extends JpaRepository<Coffee, Integer> {
    Coffee findCoffeeByCoffeeName(String CoffeeName);

}
