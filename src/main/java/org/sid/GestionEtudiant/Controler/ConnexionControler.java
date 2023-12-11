package org.sid.GestionEtudiant.Controler;

import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

//Exemple pour un contrôleur de connexion
@Controller
@RequestMapping("/connexion")
public class ConnexionControler {

 @Autowired
 private UtilisateurService utilisateurService;

 @PostMapping("/login")
 public String login(@RequestParam("nomUtilisateur") String nomUtilisateur,
                     @RequestParam("motDePasse") String motDePasse,
                     HttpSession session) {

     Utilisateur utilisateur = utilisateurService.getByNomUtilisateur(nomUtilisateur);

     if (utilisateur != null && encoder.matches(motDePasse, utilisateur.getMotDePasse())) {
         // Vérifier si le mot de passe doit être changé
         if (motDePasseEstParDefaut(utilisateur)) {
             session.setAttribute("changementMotDePasse", true);
             return "redirect:/changerMotDePasse";
         }

         // Authentification réussie, rediriger vers le tableau de bord approprié
         return "redirect:/tableauDeBord";
     } else {
         // Échec de l'authentification, rediriger vers la page de connexion avec un message d'erreur
         return "redirect:/connexion?erreur=authentification";
     }
 }

 private boolean motDePasseEstParDefaut(Utilisateur utilisateur) {
     // Logique pour vérifier si le mot de passe est celui par défaut
     // Retourne true si le mot de passe doit être changé
 }
}

