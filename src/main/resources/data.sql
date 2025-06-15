/*
DROP DATABASE IF EXISTS DB_T2_Shupingahua_Erik;
CREATE DATABASE DB_T2_Shupingahua_Erik;
USE DB_T2_Shupingahua_Erik;
 */

-- Crear tabla country
DROP TABLE IF EXISTS provider;
DROP TABLE IF EXISTS country;

CREATE TABLE country (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL
);

INSERT INTO country (name) VALUES
                               ('Perú'),
                               ('México'),
                               ('Colombia'),
                               ('Argentina'),
                               ('Chile');

-- Crear tabla provider
CREATE TABLE provider (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          doc_number VARCHAR(11) NOT NULL,
                          name VARCHAR(100),
                          phone VARCHAR(20),
                          email VARCHAR(100),
                          idpais INT,
                          FOREIGN KEY (idpais) REFERENCES country(id)
);

-- Insertar datos de ejemplo
INSERT INTO provider (doc_number, name, phone, email, idpais) VALUES
                                                                  ('12345678901', 'Proveedor A', '987654321', 'proveedorA@excom.com', 1),
                                                                  ('23456789012', 'Proveedor B', '912345678', 'proveedorB@apple.com', 2);
