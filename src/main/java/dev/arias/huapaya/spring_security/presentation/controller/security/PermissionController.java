package dev.arias.huapaya.spring_security.presentation.controller.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.spring_security.persistence.entity.PermissionEntity;
import dev.arias.huapaya.spring_security.service.interfaces.PermissionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "permission")
public class PermissionController {

    private final PermissionService permissionService;

    @PreAuthorize("hasAuthority('PRODUCT_CREATE_ONE')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<PermissionEntity> permissions) {
        Map<String, Object> response = new HashMap<>();
        List<PermissionEntity> permissionsCreate = this.permissionService.save(permissions);
        response.put("message", "Successful creation");
        response.put("permission", permissionsCreate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('PRODUCT_CREATE_ONE')")
    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        Map<String, Object> response = new HashMap<>();
        Page<PermissionEntity> permissionPage = this.permissionService.findAll(pageable);
        response.put("message", "Page permission");
        response.put("permission", permissionPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('PRODUCT_CREATE_ONE')")
    @GetMapping(path = "{rol_id}")
    public ResponseEntity<?> findByRol_Id(@PathVariable Long rol_id) {
        Map<String, Object> response = new HashMap<>();
        List<PermissionEntity> permissionsList = this.permissionService.findByRol_Id(rol_id);
        response.put("message", "List of permissions by rol id");
        response.put("permission", permissionsList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
