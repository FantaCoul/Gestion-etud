package org.sid.GestionEtudiant.Repository;

import java.util.Optional;

import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
 Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);
}


