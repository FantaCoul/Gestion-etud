package org.sid.GestionEtudiant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login1")
    public String login() {
        return "login"; // Ceci renvoie le nom de la page Thymeleaf (login.html)
    }
    
}

