package com.example.cardatabase;

import com.example.cardatabase.domain.AppUser;
import com.example.cardatabase.domain.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AppRepositoryTest {
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    void saveAppUser() {
        AppUser user = new AppUser("user1", "password", "role");
        appUserRepository.save(user);
        Optional<AppUser> foundUser = appUserRepository.findByUsername("user1");

        assertThat(foundUser).isPresent();

        assertThat(foundUser.get().getUsername()).isEqualTo("user1");
    }
}
