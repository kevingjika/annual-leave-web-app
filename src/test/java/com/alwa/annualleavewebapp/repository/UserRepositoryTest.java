package com.alwa.annualleavewebapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.alwa.annualleavewebapp.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setAddress("Fier, Albania");
        user.setEmail("gjikakevin@gmail.com");
        user.setPassword("f9jpezhmbcvp");
        user.setFirstname("Kevin");
        user.setLastname("Gjika");
        user.setUsername("kevingjika");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

        User user1 = new User();
        user.setAddress("Ballsh, Albania");
        user.setEmail("arbismalasi@gmail.com");
        user.setPassword("fjiosajoifat");
        user.setFirstname("Arbis");
        user.setLastname("Malasi");
        user.setUsername("arbismalasi");

        User savedUser1 = repo.save(user1);

        User existUser1 = entityManager.find(User.class, savedUser1.getId());

        assertThat(user1.getEmail()).isEqualTo(existUser1.getEmail());

    }

}

