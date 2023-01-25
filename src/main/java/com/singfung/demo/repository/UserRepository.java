package com.singfung.demo.repository;

import com.singfung.demo.model.entity.User;
import com.singfung.demo.model.enumeration.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author sing-fung
 * @since 1/22/2023
 */

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>
{
    List<User> findByStatus(UserStatus status);

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.status = 'able' ")
    User findByUsername(String username);
}
