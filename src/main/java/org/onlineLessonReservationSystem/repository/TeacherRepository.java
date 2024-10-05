package org.onlineLessonReservationSystem.repository;

import org.onlineLessonReservationSystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Ekstra sorgular için gerekli yöntemler
}
