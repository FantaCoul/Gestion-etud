package org.sid.GestionEtudiant.Repository;

import java.util.Optional;

import org.sid.GestionEtudiant.Entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(String nom);
}
