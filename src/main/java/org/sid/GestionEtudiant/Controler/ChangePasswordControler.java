package org.sid.GestionEtudiant.Controler;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordControler {

    @GetMapping("/change-password")
    public String showChangePasswordForm() {
        // Logique pour afficher le formulaire de changement de mot de passe
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirmPassword") String confirmPassword,
                                 Principal principal,
                                 Model model) {
        // Logique pour vérifier l'ancien mot de passe et changer le mot de passe
        // Utilisez votre service utilisateur pour effectuer ces opérations
        // Assurez-vous de gérer les erreurs et de renvoyer les messages appropriés

        return "redirect:/dashboard"; // Redirection vers le tableau de bord après le changement de mot de passe réussi
    }
}
