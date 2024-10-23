package dev.arias.huapaya.spring_security.presentation.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.spring_security.persistence.entity.ProductEntity;
import dev.arias.huapaya.spring_security.service.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RequestMapping(path = "product")
@RestController
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasAuthority('PERMISSION_CREATE_ONE')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductEntity product) {
        Map<String, Object> response = new HashMap<>();
        ProductEntity productCreate = this.productService.save(product);
        response.put("message", "Successful creation");
        response.put("product", productCreate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('PERMISSION_READ_ALL')")
    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        Map<String, Object> response = new HashMap<>();
        Page<ProductEntity> productPage = this.productService.findAll(pageable);
        response.put("message", "Page product");
        response.put("product", productPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
