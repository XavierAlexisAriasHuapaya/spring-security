package dev.arias.huapaya.spring_security.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.spring_security.persistence.entity.PermissionEntity;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    public List<PermissionEntity> findByRol_Id(Long rol_id);

}
