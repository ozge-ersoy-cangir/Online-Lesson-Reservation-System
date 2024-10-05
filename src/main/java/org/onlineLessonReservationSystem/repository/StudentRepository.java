package org.onlineLessonReservationSystem.repository;

import org.onlineLessonReservationSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Ekstra sorgular için gerekli yöntemler
}
