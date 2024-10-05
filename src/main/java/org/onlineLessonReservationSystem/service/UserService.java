package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.User;
import org.onlineLessonReservationSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Tüm kullanıcıları getir
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Belirli bir ID'ye sahip kullanıcıyı getir
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Kullanıcıyı username ile bul
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Yeni kullanıcı oluştur
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Mevcut kullanıcıyı güncelle
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            updatedUser.setRole(user.getRole());
            return userRepository.save(user);
        });
    }

    // Belirli bir kullanıcıyı sil
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    public User saveUser(String username, String password, boolean isStudent) {
        return null;
    }

    public User findById(long l) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }
}



