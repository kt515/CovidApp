package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
// This inserts 4 user record when run
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
        user.setFirstName("AARON");
        user.setLastName("LAKE");
        user.setRoles("ROLE_PUBLIC");
        user.setPassword("aaronlake");

        User savedUser = repo.save(user); //saved to repository

        user.setId("9240447");
        user.setFirstName("MISTER");
        user.setLastName("BOB");
        user.setRoles("ROLE_BUSINESS");
        user.setPassword("password");

        User savedUser1 = repo.save(user); // save to repo

        user.setId("9150467");
        user.setFirstName("HELLO");
        user.setLastName("KITTY");
        user.setRoles("ROLE_HCORG");
        user.setPassword("password");

        User savedUser2 = repo.save(user); // save to repo

        user.setId("8223878");
        user.setFirstName("JOHN");
        user.setLastName("DOE");
        user.setRoles("ROLE_HCSTAFF");
        user.setPassword("password");

        User savedUser3 = repo.save(user); // save to repo

        // see if Id is created in Database
        User existUser = entityManager.find(User.class, savedUser3.getId());
        assertThat(existUser.getId()).isEqualTo(user.getId());
    }
}
