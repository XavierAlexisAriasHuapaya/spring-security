package dev.arias.huapaya.spring_security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.spring_security.persistence.entity.OperationEntity;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    @Query("SELECT o FROM OperationEntity o WHERE o.permitAll = true")
    public List<OperationEntity> findByPublicAccess();

}
