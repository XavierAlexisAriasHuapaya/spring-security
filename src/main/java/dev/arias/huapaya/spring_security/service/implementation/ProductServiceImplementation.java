package dev.arias.huapaya.spring_security.service.implementation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.arias.huapaya.spring_security.persistence.entity.ProductEntity;
import dev.arias.huapaya.spring_security.persistence.repository.ProductRepository;
import dev.arias.huapaya.spring_security.service.interfaces.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return this.productRepository.save(entity);
    }

    @Override
    public ProductEntity update(ProductEntity entity, Long id) {
        ProductEntity productUpdate = this.findById(id).get();
        productUpdate.setDescription(entity.getDescription());
        productUpdate.setAmount(entity.getAmount());
        productUpdate.setPrice(entity.getPrice());
        return this.productRepository.save(productUpdate);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

}
