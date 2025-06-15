
-- ============================
-- SCRIPT COMPLETO DE CARGA DE DATOS
-- ============================

-- Insertar datos en tb_catalogo
INSERT INTO tb_catalogo (id, codigo, descripcion) VALUES
                                                      (1, 'CAT001', 'Tipo de Documento'),
                                                      (2, 'CAT002', 'Método de Pago'),
                                                      (3, 'CAT003', 'Estado de Pago'),
                                                      (4, 'CAT004', 'Tipo de Comprobante'),
                                                      (5, 'CAT005', 'Categoría Producto'),
                                                      (6, 'CAT006', 'Información de emisor para Comprobante');

-- Insertar datos en tb_catalogo_valor
INSERT INTO tb_catalogo_valor (id, codigo, descripcion, valor, id_catalogo) VALUES
                                                                                (1, 'VAL001', 'DNI', 'DNI', 1),
                                                                                (2, 'VAL002', 'RUC', 'RUC', 1),
                                                                                (3, 'VAL003', 'Efectivo', 'Efectivo', 2),
                                                                                (4, 'VAL004', 'Tarjeta', 'Tarjeta', 2),
                                                                                (5, 'VAL005', 'Pagado', 'Pagado', 3),
                                                                                (6, 'VAL006', 'Pendiente', 'Pendiente', 3),
                                                                                (7, 'VAL007', 'Boleta', 'Boleta', 4),
                                                                                (8, 'VAL008', 'Factura', 'Factura', 4),
                                                                                (9, 'VAL009', 'Electrónica', 'Electrónica', 4),
                                                                                (10, 'VAL010', 'Tecnología', 'Tecnología', 5),
                                                                                (11, 'VAL011', 'Hogar', 'Hogar', 5),
                                                                                (12, 'VAL012', 'Deportes', 'Deportes', 5),
                                                                                (13, 'VAL013', 'Libros', 'Libros', 5),
                                                                                (14, 'VAL014', 'Moda', 'Moda', 5),
                                                                                (15, 'VAL015', 'Ruc Emisor', '1111233685', 6),
                                                                                (16, 'VAL016', 'Nombre Emisor', 'CIBERTEC ORG LPII', 6);

-- Insertar perfiles
INSERT INTO seg_perfil (id, nombre) VALUES
                                        (1, 'Administrador'),
                                        (2, 'Cliente'),
                                        (3, 'Contabilidad');

-- Insertar roles
INSERT INTO seg_rol (id, nombre, ruta, icono, css, descripcion) VALUES
                                                                    (1, 'Acceso Total', '/', 'admin-icon', 'admin-css', 'Acceso completo al sistema'),
                                                                    (2, 'Acceso Store', '/store', 'store-icon', 'store-css', 'Acceso a módulo Store'),
                                                                    (3, 'Pagos y Pedidos', '/pagos', 'conta-icon', 'conta-css', 'Acceso a pagos y pedidos');

-- Insertar accesos
INSERT INTO seg_acceso (perfil_id, rol_id) VALUES
                                               (1, 1),
                                               (2, 2),
                                               (3, 3);

-- Insertar personas (2 naturales, 2 jurídicas, 10 proveedores)
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion, fechaNacimiento, genero) VALUES
                                                                                                                                                (1, 'Juan', 'Pérez', 1, '12345678', '987654321', 'Av. Perú 123', '1985-05-15', 'M'),
                                                                                                                                                (2, 'Ana', 'Lopez', 1, '87654321', '912345678', 'Calle Lima 456', '1990-08-20', 'F'),
                                                                                                                                                (3, 'Empresa S.A.C.', '', 2, '20123456789', '999888777', 'Jr. Cusco 789', NULL, ''),
                                                                                                                                                (4, 'Corporación ABC', '', 2, '20456789123', '933222111', 'Av. Arequipa 321', NULL, '');

-- Insertar proveedores (personas jurídicas desde id 10 al 19)
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (10, 'Proveedor 10', '', 2, '2000000010', '90000010', 'Calle Proveedor 10');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (11, 'Proveedor 11', '', 2, '2000000011', '90000011', 'Calle Proveedor 11');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (12, 'Proveedor 12', '', 2, '2000000012', '90000012', 'Calle Proveedor 12');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (13, 'Proveedor 13', '', 2, '2000000013', '90000013', 'Calle Proveedor 13');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (14, 'Proveedor 14', '', 2, '2000000014', '90000014', 'Calle Proveedor 14');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (15, 'Proveedor 15', '', 2, '2000000015', '90000015', 'Calle Proveedor 15');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (16, 'Proveedor 16', '', 2, '2000000016', '90000016', 'Calle Proveedor 16');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (17, 'Proveedor 17', '', 2, '2000000017', '90000017', 'Calle Proveedor 17');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (18, 'Proveedor 18', '', 2, '2000000018', '90000018', 'Calle Proveedor 18');
INSERT INTO tb_persona (idPersona, nombres_razonsocial, apellidos, tipo_doc, numeroDocumento, telefono, direccion) VALUES (19, 'Proveedor 19', '', 2, '2000000019', '90000019', 'Calle Proveedor 19');
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (1, 'prov10@mail.com', '90000010', 10);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (2, 'prov11@mail.com', '90000011', 11);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (3, 'prov12@mail.com', '90000012', 12);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (4, 'prov13@mail.com', '90000013', 13);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (5, 'prov14@mail.com', '90000014', 14);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (6, 'prov15@mail.com', '90000015', 15);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (7, 'prov16@mail.com', '90000016', 16);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (8, 'prov17@mail.com', '90000017', 17);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (9, 'prov18@mail.com', '90000018', 18);
INSERT INTO tb_provider (id, email, telefono, id_persona) VALUES (10, 'prov19@mail.com', '90000019', 19);
-- Insertar usuarios
INSERT INTO seg_usuario (id, username, password, correo, perfil_id, persona_id) VALUES
                                                                                    (1, 'admin', 'admin123', 'admin@mail.com', 1, 1),
                                                                                    (2, 'cliente1', '123456', 'cli1@mail.com', 2, 2),
                                                                                    (3, 'cliente2', '123456', 'cli2@mail.com', 2, 3),
                                                                                    (4, 'conta', 'conta123', 'conta@mail.com', 3, 4),
                                                                                    (5, 'extra', '123456', 'extra@mail.com', 2, 1);

-- Insertar productos
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (1, 'PC Ultra', 100, 11.0, 1, 11, 2);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (2, 'Proyector V1 ', 100, 12.0, 1, 12, 3);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (3, 'Camara Go', 100, 13.0, 1, 13, 4);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (4, 'Mouse Leagina', 100, 14.0, 1, 14, 5);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (5, 'Care Halion', 100, 15.0, 1, 10, 6);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (6, 'Smart Watch', 100, 16.0, 1, 11, 7);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (7, 'Phone V3', 100, 17.0, 1, 12, 8);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (8, 'Alpto2', 100, 18.0, 1, 13, 9);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (9, 'SAS Cloud', 100, 19.0, 1, 14, 10);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (10, 'Pc 1', 100, 20.0, 1, 10, 1);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (11, 'CardMem', 100, 21.0, 1, 11, 2);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (12, 'Drone v', 100, 22.0, 1, 12, 3);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (13, 'iPad', 100, 23.0, 1, 13, 4);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (14, 'Mouse Graf', 100, 24.0, 1, 14, 5);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (15, 'Card Vid', 100, 25.0, 1, 10, 6);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (16, 'Smart 1', 100, 26.0, 1, 11, 7);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (17, 'Liam Card', 100, 27.0, 1, 12, 8);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (18, 'Lotus ', 100, 28.0, 1, 13, 9);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (19, 'HP Prliant', 100, 29.0, 1, 14, 10);
INSERT INTO tb_producto (id, descripcion, stock, precio, estado, categoria, id_proveedor) VALUES (20, 'Mouse Marca Ratón', 100, 30.0, 1, 10, 1);
-- Insertar pedidos
INSERT INTO tb_pedido (id, canal, fecha, cod_usua) VALUES (1, 'web', '2024-06-11', 2);
INSERT INTO tb_pedido (id, canal, fecha, cod_usua) VALUES (2, 'web', '2024-06-12', 3);
INSERT INTO tb_pedido (id, canal, fecha, cod_usua) VALUES (3, 'web', '2024-06-13', 4);
INSERT INTO tb_pedido (id, canal, fecha, cod_usua) VALUES (4, 'web', '2024-06-14', 5);
INSERT INTO tb_pedido (id, canal, fecha, cod_usua) VALUES (5, 'web', '2024-06-15', 1);
-- Insertar detalles de pedidos (3 productos por pedido)
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 11.0, 1, 1);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 12.0, 1, 2);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 13.0, 1, 3);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 14.0, 2, 4);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 15.0, 2, 5);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 16.0, 2, 6);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 17.0, 3, 7);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 18.0, 3, 8);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 19.0, 3, 9);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 20.0, 4, 10);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 21.0, 4, 11);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 22.0, 4, 12);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 23.0, 5, 13);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 24.0, 5, 14);
INSERT INTO tb_pedido_detalle (cantidad, descuento, precio, id_pedido, id_prod) VALUES (1, 0, 25.0, 5, 15);
-- Insertar pagos (2 pedidos con pagos)
INSERT INTO tb_pago (fechapago, monto, referencia, estado, metodo, pedido_id) VALUES
                                                                                  ('2024-06-15 10:00:00', 35.0, 'OP12345', 5, 3, 1),
                                                                                  ('2024-06-16 14:30:00', 50.0, 'OP67890', 5, 4, 2);

-- Insertar comprobantes (de los 2 pagos)
INSERT INTO tb_comprobante (fechaEmision, numero, info_emisor, serie, pedido_id, tipo) VALUES
                                                                                                            ('2024-06-15 10:05:00', '001-0001',  6, 'F001', 1, 8),
                                                                                                            ('2024-06-16 14:35:00', '001-0002',  6, 'F001', 2, 7);
