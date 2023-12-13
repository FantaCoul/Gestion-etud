package org.sid.GestionEtudiant.Service.Impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// DetailsUtilisateurServiceImpl.java
@Service
public class DetailsUtilisateurServiceImpl implements UserDetailsService {

    private final UtilisateurService utilisateurService;

    public DetailsUtilisateurServiceImpl(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurService.findByNomUtilisateur(nomUtilisateur);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur : " + nomUtilisateur);
        }

        Set<GrantedAuthority> authorities = utilisateur.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNom()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                utilisateur.getNomUtilisateur(),
                utilisateur.getMotDePasse(),
                authorities
        );
    }
}
