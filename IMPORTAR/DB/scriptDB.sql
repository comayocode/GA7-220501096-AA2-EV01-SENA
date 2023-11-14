CREATE DATABASE almacen;
USE almacen;

CREATE TABLE  productos (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `codigo` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(40) NOT NULL,
  `precio` DECIMAL(10,2) NULL DEFAULT NULL,
  `existencia` INT NOT NULL);
  
INSERT INTO productos (codigo, nombre, precio, existencia)
VALUES 
( '001', 'Papas Margarita 500gr', 2000.00, 98),
('002', 'Quipitos', 1200.00, 110),
('003', 'Queso Alpina 180gr', 3800.00, 43),
('004', 'Yogurt Finesse 1500gr', 16500.00, 20);