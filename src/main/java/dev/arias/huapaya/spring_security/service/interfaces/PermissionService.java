package dev.arias.huapaya.spring_security.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.arias.huapaya.spring_security.persistence.entity.PermissionEntity;

public interface PermissionService {

    public PermissionEntity save(PermissionEntity entity);

    public Page<PermissionEntity> findAll(Pageable pageable);

    public List<PermissionEntity> findByRol_Id(Long rol_id);

}
