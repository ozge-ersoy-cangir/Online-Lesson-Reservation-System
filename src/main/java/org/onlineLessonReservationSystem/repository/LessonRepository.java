package org.onlineLessonReservationSystem.repository;

import org.onlineLessonReservationSystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    // Özel sorgular için gerekli metodlar
}
