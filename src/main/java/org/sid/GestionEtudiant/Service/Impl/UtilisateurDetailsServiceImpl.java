package org.sid.GestionEtudiant.Service.Impl;


import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur: " + nomUtilisateur));

        return new UtilisateurDetails(utilisateur);
    }
}
