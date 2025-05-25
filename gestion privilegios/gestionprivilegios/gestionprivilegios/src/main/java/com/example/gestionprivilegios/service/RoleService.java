package com.example.gestionprivilegios.service; 

import com.example.gestionprivilegios.model.Permiso; 
import com.example.gestionprivilegios.model.Role; 
import com.example.gestionprivilegios.repository.PermisoRepository; 
import com.example.gestionprivilegios.repository.RoleRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import java.util.List; 
import java.util.Optional; 
import java.util.Set; 
import java.util.HashSet; 

@Service 
public class RoleService {

    @Autowired 
    private RoleRepository roleRepository;

    @Autowired 
    private PermisoRepository permisoRepository;

    
    public List<Role> getAllRoles() {
        return roleRepository.findAll(); 
    }

    
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id); 
    }

    
    public Role createRole(Role role) {
        return roleRepository.save(role); 
    }

    
    public Role updateRole(Long id, Role updatedRole) {
        
        return roleRepository.findById(id).map(role -> {
            role.setName(updatedRole.getName());
            role.setDescription(updatedRole.getName()); 
            
            return roleRepository.save(role);
        }).orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    
    
    
    
    
    

    
    public void deleteRole(Long id) {
        roleRepository.deleteById(id); 
    }

    
    public Role assignPermisosToRole(Long roleId, Set<Long> permisoIds) {
        Role role = roleRepository.findById(roleId)
                                  .orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));

        Set<Permiso> permisos = new HashSet<>();
        for (Long permId : permisoIds) {
            Permiso permiso = permisoRepository.findById(permId)
                                              .orElseThrow(() -> new RuntimeException("Permiso not found with id " + permId));
            permisos.add(permiso);
        }
        role.setPermisos(permisos); 
        return roleRepository.save(role); 
    }

    
    public Role addPermisoToRole(Long roleId, Long permisoId) {
        Role role = roleRepository.findById(roleId)
                                  .orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));
        Permiso permiso = permisoRepository.findById(permisoId)
                                          .orElseThrow(() -> new RuntimeException("Permiso not found with id " + permisoId));

        role.getPermisos().add(permiso); 
        return roleRepository.save(role); 
    }

    
    public Role removePermisoFromRole(Long roleId, Long permisoId) {
        Role role = roleRepository.findById(roleId)
                                  .orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));
        Permiso permisoToRemove = permisoRepository.findById(permisoId)
                                                  .orElseThrow(() -> new RuntimeException("Permiso not found with id " + permisoId));

        role.getPermisos().remove(permisoToRemove); 
        return roleRepository.save(role); 
    }
}