package org.sid.GestionEtudiant.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



//Exemple pour un contrôleur de connexion
@Controller
public class ConnexionControler {


 @GetMapping("/Login1")
 public String login() {
     // Logique pour afficher le formulaire de changement de mot de passe
     return "Login";
 }


}

