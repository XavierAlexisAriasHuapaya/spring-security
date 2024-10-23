package dev.arias.huapaya.spring_security.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.spring_security.persistence.entity.PermissionEntity;
import dev.arias.huapaya.spring_security.persistence.entity.RolEntity;
import dev.arias.huapaya.spring_security.persistence.repository.PermissionRepository;
import dev.arias.huapaya.spring_security.service.interfaces.PermissionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PermissionServiceImplementation implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Transactional(readOnly = false)
    @Override
    public List<PermissionEntity> save(List<PermissionEntity> permissions) {
        List<PermissionEntity> permissionsCreate = new ArrayList<>();
        if (!permissions.isEmpty()) {
            RolEntity rol = permissions.get(0).getRol();
            this.deletePermissionsByRole(rol);
            permissionsCreate = this.createPermission(permissions);
        }
        return permissionsCreate;
    }

    @Transactional
    private void deletePermissionsByRole(RolEntity rol) {
        this.permissionRepository.deleteByRol_Id(rol.getId());
    }

    private List<PermissionEntity> createPermission(List<PermissionEntity> permissions) {
        List<PermissionEntity> permissionsCreate = new ArrayList<>();
        permissions.forEach(permission -> {
            PermissionEntity permissionCreate = new PermissionEntity();
            permissionCreate.setRol(permission.getRol());
            permissionCreate.setOperations(permission.getOperations());
            this.permissionRepository.save(permissionCreate);
            permissionsCreate.add(permissionCreate);
        });
        return permissionsCreate;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<PermissionEntity> findAll(Pageable pageable) {
        return this.permissionRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PermissionEntity> findByRol_Id(Long rol_id) {
        return this.permissionRepository.findByRol_Id(rol_id);
    }

}
