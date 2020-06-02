package koffieApp.repository;

import koffieApp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueryRepository extends JpaRepository<Order, Integer> {
    Order findFirstByOrderByIdDesc();
}
