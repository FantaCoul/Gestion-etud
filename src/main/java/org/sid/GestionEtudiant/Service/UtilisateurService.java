package org.sid.GestionEtudiant.Service;


import java.util.Set;

import org.sid.GestionEtudiant.Entites.Role;
import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.springframework.stereotype.Service;

@Service
//UtilisateurService.java
public interface UtilisateurService {
 Utilisateur creerUtilisateur(Utilisateur utilisateur);
 void attribuerRoles(Long utilisateurId, Set<Role> roles);
 Utilisateur changerMotDePasse(Long utilisateurId, String nouveauMotDePasse);
Utilisateur findByNomUtilisateur(String nomUtilisateur);
}

