package com.justcode.repository;

import com.justcode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user from User user where user.username = ?1")
    User findUserByName(String username);

    @Query("SELECT user from User user where user.email = ?1")
    User findUserByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE User SET points = points + ?2 WHERE id = ?1")
    void updateUsersPoints(Long id, int points);
}
