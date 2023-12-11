package org.sid.GestionEtudiant.Api;

import java.util.Set;

import org.sid.GestionEtudiant.Entites.Role;
import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//UtilisateurController.java
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurApi {

 @Autowired
 private UtilisateurService utilisateurService;

 @PostMapping("/creer-utilisateur")
 public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
     Utilisateur createdUtilisateur = utilisateurService.creerUtilisateur(utilisateur);
     return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
 }

 @PostMapping("/attribuer-roles/{utilisateurId}")
 public ResponseEntity<Void> attribuerRoles(@PathVariable Long utilisateurId, @RequestBody Set<Role> roles) {
     utilisateurService.attribuerRoles(utilisateurId, roles);
     return new ResponseEntity<>(HttpStatus.OK);
 }

 @PostMapping("/changer-mot-de-passe/{utilisateurId}")
 public ResponseEntity<Utilisateur> changerMotDePasse(@PathVariable Long utilisateurId, @RequestBody String nouveauMotDePasse) {
     Utilisateur updatedUtilisateur = utilisateurService.changerMotDePasse(utilisateurId, nouveauMotDePasse);
     return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
 }
}


