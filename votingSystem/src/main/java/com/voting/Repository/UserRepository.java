package com.voting.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voting.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
     @Query("SELECT u FROM User u WHERE LOWER(u.emailId) = LOWER(:email)")
    Optional<User> findByEmailId(@Param("email") String email);
}

