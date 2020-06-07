package koffieApp.repository;

import koffieApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQueryRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserById(int id);

}
