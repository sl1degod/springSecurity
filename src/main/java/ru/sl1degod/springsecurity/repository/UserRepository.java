package ru.sl1degod.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sl1degod.springsecurity.models.MyUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findMyUserByName(String username);
}
