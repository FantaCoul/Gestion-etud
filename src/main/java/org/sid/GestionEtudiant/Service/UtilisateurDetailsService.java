package org.sid.GestionEtudiant.Service;


import org.sid.GestionEtudiant.Service.Impl.UtilisateurServiceImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurDetailsService extends UserDetailsService {
    UtilisateurServiceImpl loadUtilisateurByUsername(String nomUtilisateur);
}
