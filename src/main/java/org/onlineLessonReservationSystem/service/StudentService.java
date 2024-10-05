package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.Student;
import org.onlineLessonReservationSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Tüm öğrencileri getir
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    // Belirli bir ID'ye sahip öğrenciyi getir
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Yeni öğrenci oluştur
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Mevcut öğrenciyi güncelle
    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEnrolledLessons(updatedStudent.getEnrolledLessons());
            return studentRepository.save(student);
        });
    }

    // Belirli bir öğrenciyi sil
    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }
}
