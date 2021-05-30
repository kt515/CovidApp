package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE u.user_id = ?1")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE CONCAT(u.user_id, ' ', u.roles, ' ', u.password) LIKE %?1%")
    List<User> search(String keyword);

    List<User> findAll();

    @Modifying
    @Query("update User u set u.password = :password, u.roles = :roles" +
            " where u.user_id = :user_id")
    void updateUser(@Param("user_id") String user_id, @Param("password") String password,
                    @Param("roles") String roles);

    @Modifying
    @Query(value = "insert into User (user_id, password, roles) values (:user_id, :password, :roles)", nativeQuery = true)
    void createUser(@Param("user_id") String user_id, @Param("password") String password,
                    @Param("roles") String roles);
}
