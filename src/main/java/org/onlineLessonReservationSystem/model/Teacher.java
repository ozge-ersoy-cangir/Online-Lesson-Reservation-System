package org.onlineLessonReservationSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "teachers")

public class Teacher extends User {
    private String name;
    private String subject;
    private String email;

    // Getter ve Setter
    public String getName() {
        return super.getRole();
    }

    public void setName(String name) {
        super.setRole(name);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}