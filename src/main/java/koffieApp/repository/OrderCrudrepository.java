package koffieApp.repository;

import koffieApp.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCrudrepository extends CrudRepository<Order, Integer> {
}
