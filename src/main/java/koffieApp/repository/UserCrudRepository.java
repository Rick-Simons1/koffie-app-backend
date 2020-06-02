package koffieApp.repository;

import koffieApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {

}


