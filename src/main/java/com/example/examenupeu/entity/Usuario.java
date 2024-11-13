package com.example.examenupeu.entity;

import java.util.Set;

import com.example.examenupeu.entity.Rol;
import com.example.examenupeu.entity.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @Column(nullable = false, unique = true)
	    private String username;
	    @Column(nullable = false, unique = true)
	    private String email;
	    @Column(nullable = false)
	    private String password;

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "usuarios_roles",
	            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
	    )
	    private Set<Rol> roles;
}
