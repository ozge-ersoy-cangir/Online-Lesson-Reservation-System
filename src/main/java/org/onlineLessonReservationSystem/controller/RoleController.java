package org.onlineLessonReservationSystem.controller;

import org.onlineLessonReservationSystem.model.Role;
import org.onlineLessonReservationSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Tüm rolleri getirir
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    // Yeni bir rol ekler
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return ResponseEntity.ok(savedRole);
    }

    // İsim ile rol bulur
    @GetMapping("/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
        Role role = roleService.findByName(name);
        return ResponseEntity.ok(role);
    }

    // Rol günceller
    @PutMapping("/{name}")
    public ResponseEntity<Role> updateRole(@PathVariable String name, @RequestBody Role roleDetails) {
        Role updatedRole = roleService.updateRole(name, roleDetails);
        return ResponseEntity.ok(updatedRole);
    }

    // Rol siler
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
        return ResponseEntity.noContent().build();
    }
}
