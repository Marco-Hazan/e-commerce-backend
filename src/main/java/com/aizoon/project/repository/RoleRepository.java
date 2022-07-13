package com.aizoon.project.repository;

import com.aizoon.project.model.ERole;
import com.aizoon.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByNome(ERole nome);

}
