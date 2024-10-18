INSERT INTO modules (name, base_path) VALUES ('AUTHENTICATION', '/auth');
INSERT INTO modules (name, base_path) VALUES ('PRODUCT', '/product');
INSERT INTO modules (name, base_path) VALUES ('PERMISSIONS', '/permission');


INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('AUTHENTICATE', '/authenticate', 'POST', true, 1);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('VALIDATE-TOKEN', '/validate', 'POST', true, 1);

INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PRODUCT_CREATE_ONE', '', 'POST', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PRODUCT_UPDATE_ONE', '/[0-9]*', 'PUT', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PRODUCT_READ_ALL', '', 'GET', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PRODUCT_READ_ONE', '/[0-9]*', 'GET', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PRODUCT_DELETE_ONE', '/[0-9]*/disabled', 'GET', false, 2);

INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PERMISSION_CREATE_ONE', '', 'POST', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PERMISSION_READ_ALL', '', 'GET', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('PERMISSION_READ_ONE', '/[0-9]*', 'GET', false, 3);

INSERT INTO roles (description, status) VALUES ('ADMINISTRATOR', true);
INSERT INTO roles (description, status) VALUES ('CUSTOMER', true);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 3);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 4);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 6);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 7);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 8);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 9);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 10);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 6);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 9);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 10);

INSERT INTO users (username, password, rol_id, status) VALUES ('administrator', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 1, true);
INSERT INTO users (username, password, rol_id, status) VALUES ('customer', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 2, true);

