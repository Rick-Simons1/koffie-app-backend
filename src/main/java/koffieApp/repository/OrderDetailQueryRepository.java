package koffieApp.repository;

import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailQueryRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findAllByOrder_Id(Integer id);
}
