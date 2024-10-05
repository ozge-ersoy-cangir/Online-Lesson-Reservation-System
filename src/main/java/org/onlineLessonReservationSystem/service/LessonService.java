package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.Lesson;
import org.onlineLessonReservationSystem.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    // Tüm dersleri getir
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    // Belirli bir ID'ye sahip dersi getir
    public Optional<Lesson> findLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    // Yeni ders oluştur
    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    // Mevcut dersi güncelle
    public Optional<Lesson> updateLesson(Long id, Lesson updatedLesson) {
        return lessonRepository.findById(id).map(lesson -> {
            lesson.setTitle(updatedLesson.getTitle());
            lesson.setDescription(updatedLesson.getDescription());
            lesson.setTeacher(updatedLesson.getTeacher());
            return lessonRepository.save(lesson);
        });
    }

    // Belirli bir dersi sil
    public boolean deleteLesson(Long id) {
        return lessonRepository.findById(id).map(lesson -> {
            lessonRepository.delete(lesson);
            return true;
        }).orElse(false);
    }

    public Lesson findById(long l) {
        return null;
    }

    public List<Lesson> findAll() {
        return null;
    }
}
