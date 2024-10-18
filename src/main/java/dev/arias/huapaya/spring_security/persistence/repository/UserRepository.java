package dev.arias.huapaya.spring_security.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.spring_security.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByUsername(String username);

}
