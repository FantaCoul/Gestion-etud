package org.sid.GestionEtudiant.Service;


import org.sid.GestionEtudiant.Service.Impl.UtilisateurDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurDetailsService extends UserDetailsService {
    UtilisateurDetails loadUtilisateurByUsername(String nomUtilisateur);
}
