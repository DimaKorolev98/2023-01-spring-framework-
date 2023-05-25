package ru.otus.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

}
