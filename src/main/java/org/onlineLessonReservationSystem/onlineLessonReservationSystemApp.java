package org.onlineLessonReservationSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.onlineLessonReservationSystem.model.Role;
import org.onlineLessonReservationSystem.model.User;
import org.onlineLessonReservationSystem.repository.UserRepository;
import org.onlineLessonReservationSystem.repository.RoleRepository;

import java.util.List;

@SpringBootApplication
public class onlineLessonReservationSystemApp {

    public static void main(String[] args) {
        SpringApplication.run(onlineLessonReservationSystemApp.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if (userRepository.findAll().isEmpty()) {
                // Rolleri oluşturma ve kaydetme
                Role adminRole = roleRepository.save(new Role("ADMIN"));
                Role studentRole = roleRepository.save(new Role("STUDENT"));
                Role teacherRole = roleRepository.save(new Role("TEACHER"));

                // Varsayılan admin kullanıcı oluşturma
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setRole(List.of(adminRole).toString());
                userRepository.save(admin);

                System.out.println("Varsayılan kullanıcı ve roller eklendi.");
            }
        };
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Uygulama başlatıldı: " + event.getTimestamp());
    }
}