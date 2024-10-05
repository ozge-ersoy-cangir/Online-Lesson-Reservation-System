package org.onlineLessonReservationSystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    private String name;

    // Constructor
    public Role(String name) {
        this.name = name;
    }
    Role role = new Role("STUDENT");

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}


