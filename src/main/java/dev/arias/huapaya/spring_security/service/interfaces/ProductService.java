package dev.arias.huapaya.spring_security.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import dev.arias.huapaya.spring_security.persistence.entity.ProductEntity;

public interface ProductService {

    ProductEntity save(ProductEntity entity);

    ProductEntity update(ProductEntity entity, Long id);

    Page<ProductEntity> findAll(Pageable pageable);

    Optional<ProductEntity> findById(Long id);

    void delete(Long id);

}
