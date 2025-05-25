package com.example.gestionprivilegios.controller; 

import com.example.gestionprivilegios.model.Role; 
import com.example.gestionprivilegios.service.RoleService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 

import java.util.List; 
import java.util.Set; 
import java.util.Map; 

@RestController 
@RequestMapping("/api/roles") 
public class RoleController {

    @Autowired 
    private RoleService roleService;

    
    
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles(); 
        return new ResponseEntity<>(roles, HttpStatus.OK); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) { 
        return roleService.getRoleById(id)
                .map(role -> new ResponseEntity<>(role, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    }

  
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) { 
        Role createdRole = roleService.createRole(role); 
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED); 
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        try {
            Role updatedRole = roleService.updateRole(id, role); 
            return new ResponseEntity<>(updatedRole, HttpStatus.OK); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

       
    @PostMapping("/{roleId}/assignPermisos")
    public ResponseEntity<Role> assignPermisosToRole(
            @PathVariable Long roleId,
            @RequestBody Map<String, Set<Long>> payload) { 
        try {
            Set<Long> permisoIds = payload.get("permisoIds"); 
            if (permisoIds == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
            }
            Role updatedRole = roleService.assignPermisosToRole(roleId, permisoIds); 
            return new ResponseEntity<>(updatedRole, HttpStatus.OK); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    
   
    @PostMapping("/{roleId}/addPermiso/{permisoId}")
    public ResponseEntity<Role> addPermisoToRole(
            @PathVariable Long roleId,
            @PathVariable Long permisoId) {
        try {
            Role updatedRole = roleService.addPermisoToRole(roleId, permisoId); 
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @DeleteMapping("/{roleId}/removePermiso/{permisoId}")
    public ResponseEntity<Role> removePermisoFromRole(
            @PathVariable Long roleId,
            @PathVariable Long permisoId) {
        try {
            Role updatedRole = roleService.removePermisoFromRole(roleId, permisoId); 
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}