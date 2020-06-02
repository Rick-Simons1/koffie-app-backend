package koffieApp.repository;

import koffieApp.domain.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeCrudRepository extends CrudRepository<Coffee, Integer> {
}
