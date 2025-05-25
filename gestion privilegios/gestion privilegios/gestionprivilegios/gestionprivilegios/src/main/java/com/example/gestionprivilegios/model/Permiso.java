package com.example.gestionprivilegios.model; 

import jakarta.persistence.*;
import lombok.Data; 
import lombok.NoArgsConstructor; 
import lombok.AllArgsConstructor; 
import java.util.Set; 

@Entity 
@Table(name = "permisos") 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Permiso { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @Column(nullable = false, unique = true) 
    private String name; 

    private String description; 

    
    
    
    @ManyToMany(mappedBy = "permisos")
    private Set<Role> roles; 
}