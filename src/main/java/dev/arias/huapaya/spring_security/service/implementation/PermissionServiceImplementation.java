package dev.arias.huapaya.spring_security.service.implementation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.spring_security.persistence.entity.PermissionEntity;
import dev.arias.huapaya.spring_security.persistence.repository.PermissionRepository;
import dev.arias.huapaya.spring_security.service.interfaces.PermissionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PermissionServiceImplementation implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Transactional(readOnly = false)
    @Override
    public PermissionEntity save(PermissionEntity entity) {
        return this.permissionRepository.save(entity);
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
