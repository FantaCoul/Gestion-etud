package org.sid.GestionEtudiant.Service;

import org.sid.GestionEtudiant.Entites.Role;

public interface RoleService {
    Role creerRole(Role role);
    Role trouverRoleParNom(String nom);
    // Ajoutez d'autres méthodes de service au besoin
}
