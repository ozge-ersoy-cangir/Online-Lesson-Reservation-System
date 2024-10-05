package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.Role;
import org.onlineLessonReservationSystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role findByName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        return role.orElseThrow(() -> new RuntimeException("Role not found: " + name));
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(String name, Role roleDetails) {
        Role role = findByName(name);
        role.setName(roleDetails.getName());
        return roleRepository.save(role);
    }

    public void deleteRole(String name) {
        Role role = findByName(name);
        roleRepository.delete(role);
    }
}
