package org.sid.GestionEtudiant.Service.Impl;


import java.util.Set;



import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Repository.UtilisateurRepository;
import org.sid.GestionEtudiant.Service.RoleService;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleService roleService) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void attribuerRoles(Long utilisateurId, Set<org.sid.GestionEtudiant.Entites.Role> roles) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
        if (utilisateur != null) {
            utilisateur.setRoles(roles);
            utilisateurRepository.save(utilisateur);
        }
    }

    @Override
    public Utilisateur changerMotDePasse(Long utilisateurId, String nouveauMotDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
        if (utilisateur != null) {
            utilisateur.setMotDePasse(nouveauMotDePasse);
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    @Override
    public Utilisateur findByNomUtilisateur(String nomUtilisateur) {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
    }

    // Ajouter un directeur avec un nom d'utilisateur et un mot de passe par défaut
   }
