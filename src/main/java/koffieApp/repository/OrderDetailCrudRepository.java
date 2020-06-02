package koffieApp.repository;

import koffieApp.domain.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailCrudRepository extends CrudRepository<OrderDetail, Integer> {
}
