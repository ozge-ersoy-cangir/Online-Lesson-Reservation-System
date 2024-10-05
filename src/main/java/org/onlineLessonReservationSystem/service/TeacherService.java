package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.Teacher;
import org.onlineLessonReservationSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Tüm öğretmenleri getir
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    // Belirli bir ID'ye sahip öğretmeni getir
    public Optional<Teacher> findTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // Yeni öğretmen oluştur
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Mevcut öğretmeni güncelle
    public Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setName(updatedTeacher.getName());
            teacher.setPassword(updatedTeacher.getPassword());
            return teacherRepository.save(teacher);
        });
    }

    // Belirli bir öğretmeni sil
    public boolean deleteTeacher(Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            teacherRepository.delete(teacher);
            return true;
        }).orElse(false);
    }
}
