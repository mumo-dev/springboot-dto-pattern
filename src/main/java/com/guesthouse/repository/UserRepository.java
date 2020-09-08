package com.guesthouse.repository;

import com.guesthouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u from  User u" +
//            " LEFT JOIN FETCH u.roles")
//    List<User> findAll();
}
