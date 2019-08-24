package org.spring.security.repositories;

import org.spring.security.oauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT DISTINCT user FROM User user " +

            "INNER JOIN FETCH user.authoritiesToGet AS authorities " +

            "WHERE user.userName = :userName")

    User findByUserName(@Param("userName") String username);
}
