package org.sid.GestionEtudiant.Entites;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;

/// Utilisateur.java
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomUtilisateur;

    @Column(nullable = false)
    private String motDePasse;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "utilisateur_roles", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

	public Utilisateur(Long id, String nomUtilisateur, String motDePasse, Set<Role> roles) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.roles = roles;
	}

	public Utilisateur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    // Getters, setters, constructeurs, etc.
    
    
}



