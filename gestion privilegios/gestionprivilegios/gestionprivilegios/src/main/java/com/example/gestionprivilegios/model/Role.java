package com.example.gestionprivilegios.model; 

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles") 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, unique = true) 
    private String name; 

    private String description; 

    
    
    @ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(
        name = "role_permisos", 
        joinColumns = @JoinColumn(name = "role_id"), 
        inverseJoinColumns = @JoinColumn(name = "permiso_id") 
    )
    private Set<Permiso> permisos = new HashSet<>(); 
}
