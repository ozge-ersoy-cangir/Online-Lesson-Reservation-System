package org.onlineLessonReservationSystem.repository;

import org.onlineLessonReservationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    Optional<User> findByUsername(String username);
}
