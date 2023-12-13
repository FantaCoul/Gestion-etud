package org.sid.GestionEtudiant.Service.Impl;

import org.sid.GestionEtudiant.Entites.Role;
import org.sid.GestionEtudiant.Repository.RoleRepository;
import org.sid.GestionEtudiant.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role creerRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role trouverRoleParNom(String nom) {
        return roleRepository.findByNom(nom);
    }

    // Ajoutez d'autres méthodes de service au besoin
}

