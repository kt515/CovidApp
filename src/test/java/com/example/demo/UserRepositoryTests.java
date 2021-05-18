package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;
    // creating a new user
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId("S9240447G");
        user.setFirstName("Aaron");
        user.setLastName("Lake");
        user.setRoles("ROLE_PUBLIC");
        user.setPassword("aaronlake");

        User savedUser = repo.save(user); //saved to repository

        // see if Id is created in Database
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getId()).isEqualTo(user.getId()); //
    }
}
