CREATE DATABASE BD_OASISDRINK;
use BD_OASISDRINK;

CREATE TABLE Usuarios(
  idUsuario int primary key auto_increment,
  nombreUsuario varchar(40),
  clave varchar(80), -- Use VARCHAR instead of CHAR, and length for the BCrypt hash.
  flagEstado ENUM('0','1')
);


/* 
insert into Usuarios(nombreUsuario, clave, flagEstado)
values('Marco Moran', '12345', '1')
*/

CREATE TABLE Medida(
idMedida int primary key auto_increment,
nombre		varchar(20),
abreviacion	char(3),
flagEstado	ENUM('0','1') 
);

/* 
insert into Medida(nombre, abreviacion, flagEstado)
values('Kilogramos', 'Kgr', '1')
*/


CREATE TABLE ProductoTipo(
tipoProducto 	 char(6) primary key,
nomTipoProducto varchar(30),
flagEstado	ENUM('0','1') 
);

/*
insert into ProductoTipo(tipoProducto, nomTipoProducto, flagEstado)
values('PPT', 'Bebidas','1')
*/

CREATE TABLE Producto(
codProducto 	 int primary key auto_increment,
nomProducto	 varchar(100),
tipoProducto	 char(6),
cantProducto	 decimal(12,2),
porcMargenGanancia decimal(12,2),
idMedida	 int, 
diasCaducidad	 int, 
flagEstado	ENUM('0','1'),  
FOREIGN KEY (tipoProducto) REFERENCES ProductoTipo(tipoProducto),
FOREIGN KEY (idMedida) REFERENCES Medida(idMedida) 
);

/*
insert into Producto(NomProducto, TipoProducto, CantProducto, porcMargenGanancia, idMedida, diasCaducidad, flagEstado)
values('Refresco de maracuya','PPT',80,0.35,1,3,'1')
*/

CREATE TABLE Insumo(
codInsumo 	 int primary key auto_increment,
idMedida	 int, 
nomInsumo	 varchar(100),
precioCosto	 decimal(10,2),
cantInsumo	 decimal(10,2),
densidad	 decimal(10,2),
flagEstado	ENUM('0','1'), 
FOREIGN KEY (idMedida) REFERENCES Medida(idMedida) 
);

/*
insert into Insumo(idMedida, nomInsumo, precioCosto, cantInsumo, densidad, flagEstado)
values(1, 'Maracuya', 5.5, 40, 1.2,'1')
*/

CREATE TABLE Receta(
codReceta int primary key auto_increment,
observacion	varchar(60),
codProducto	int, 
flagEstado	ENUM('0','1'), 
FOREIGN KEY (codProducto) REFERENCES Producto(codProducto) 
);

/*
insert into Receta(observacion, codProducto, flagEstado)
values('Receta para preparar Maracuya tipo OasisDrink', 1, '1')
*/


CREATE TABLE RecetaDetalle(
codReceta int,
codInsumo int,
cantidad      decimal(10,2),
PRIMARY KEY (codReceta, codInsumo), 
FOREIGN KEY (codInsumo) REFERENCES Insumo(codInsumo) 
);

/*
insert into RecetaDetalle(codReceta, codInsumo, cantidad)
values(1,1,10)
*/

CREATE TABLE OrdenVenta(
codigoOrden int primary key auto_increment,
fecha		date,
flagEstado	ENUM('0','1'), 
observaciones	varchar(100) 
);

/*
insert into OrdenVenta(fecha, flagEstado, Observaciones)
values('2023-07-01','1','Pedido de Rommel de 100 litros de refresco de maracuya')
//Ojo, si desean ingresar por defecto la fecha actual se usa curdate()
*/

CREATE TABLE ProductoVenta(
codigoOrden int,
codProducto int,
cantidad      decimal(10,2),
PRIMARY KEY (codigoOrden, codProducto), 
FOREIGN KEY (codProducto) REFERENCES Producto(codProducto) 
);

CREATE TABLE OrdenProduccion(
idOrden		int primary key auto_increment,
fecha		date,
flagEstado	ENUM('0','1'), 
observaciones	varchar(100) 
);

CREATE TABLE OrdenPPT(
idOrden		int,
codReceta	int,
cantidad	decimal(10,2),
PRIMARY KEY (idOrden, codReceta), 
FOREIGN KEY (codReceta) REFERENCES Receta(codReceta) 
);


-- DATA
-- Insert data into Usuarios table
-- INSERT INTO Usuarios (nombreUsuario, clave, flagEstado) VALUES
--   ('Marco Moran', '12345', '1'),
--   ('Ana Lopez', 'abcdef', '1'),
--   ('Diego Perez', 'p@ssw0rd', '1'),
--   ('Laura Martinez', 'secure12', '1'),
--   ('Carlos Ramirez', 'hello123', '1');

-- Insert data into Medida table
INSERT INTO Medida (nombre, abreviacion, flagEstado) VALUES
  ('Litro', 'L', '1'),
  ('Mililitro', 'mL', '1'),
  ('Kilogramo', 'Kgr', '1'),
  ('Unidad', 'u', '1'),
  ('Gramo', 'g', '1');

-- Insert data into ProductoTipo table
INSERT INTO ProductoTipo (tipoProducto, nomTipoProducto, flagEstado) VALUES
  ('PPT', 'Bebidas', '1'),
  ('PAA', 'Alimentos', '1'),
  ('PST', 'Postres', '1'),
  ('PCR', 'Cervezas', '1'),
  ('PCA', 'Cafés', '1');

-- Insert data into Producto table
INSERT INTO Producto (nomProducto, tipoProducto, cantProducto, porcMargenGanancia, idMedida, diasCaducidad, flagEstado) VALUES
  ('Refresco de maracuya', 'PPT', 80, 0.35, 1, 3, '1'),
  ('Agua mineral', 'PPT', 500, 0.25, 2, 7, '1'),
  ('Tarta de limón', 'PST', 10, 0.5, 4, 5, '1'),
  ('Cerveza artesanal', 'PCR', 20, 0.6, 3, 30, '1'),
  ('Café latte', 'PCA', 12, 0.4, 2, NULL, '1');

-- Insert data into Insumo table
INSERT INTO Insumo (idMedida, nomInsumo, precioCosto, cantInsumo, densidad, flagEstado) VALUES
  (1, 'Maracuya', 5.5, 40, 1.2, '1'),
  (2, 'Agua purificada', 1.2, 100, NULL, '1'),
  (3, 'Harina', 2.0, 25, 0.8, '1'),
  (4, 'Lúpulo', 3.5, 5, 0.5, '1'),
  (5, 'Café molido', 8.0, 30, NULL, '1');

-- Insert data into Receta table
INSERT INTO Receta (observacion, codProducto, flagEstado) VALUES
  ('Receta para preparar Maracuya tipo OasisDrink', 1, '1'),
  ('Receta para preparar Tarta de limón', 3, '1'),
  ('Receta para preparar Cerveza artesanal', 4, '1'),
  ('Receta para preparar Café latte', 5, '1'),
  ('Receta para preparar Café americano', 5, '1');

-- Insert data into RecetaDetalle table
INSERT INTO RecetaDetalle (codReceta, codInsumo, cantidad) VALUES
  (1, 1, 10),
  (1, 2, 30),
  (2, 3, 5),
  (3, 4, 2),
  (4, 5, 6);

-- Insert data into OrdenVenta table
INSERT INTO OrdenVenta (fecha, flagEstado, observaciones) VALUES
  ('2023-07-01', '1', 'Pedido de Rommel de 100 litros de refresco de maracuya'),
  ('2023-07-02', '1', 'Pedido de Karen de 200 litros de agua mineral'),
  ('2023-07-03', '1', 'Pedido de Jorge de 2 tartas de limón'),
  ('2023-07-04', '1', 'Pedido de Carlos de 10 cajas de cerveza artesanal'),
  ('2023-07-05', '1', 'Pedido de Ana de 50 cafés latte');

-- Insert data into ProductoVenta table
INSERT INTO ProductoVenta (codigoOrden, codProducto, cantidad) VALUES
  (1, 1, 100),
  (2, 2, 500),
  (3, 3, 2),
  (4, 4, 20),
  (5, 5, 50);

-- Insert data into OrdenProduccion table
INSERT INTO OrdenProduccion (fecha, flagEstado, observaciones) VALUES
  ('2023-07-01', '1', 'Producción de refrescos de maracuya'),
  ('2023-07-02', '1', 'Producción de agua mineral'),
  ('2023-07-03', '1', 'Producción de tartas de limón'),
  ('2023-07-04', '1', 'Producción de cerveza artesanal'),
  ('2023-07-05', '1', 'Producción de cafés latte');

-- Insert data into OrdenPPT table
INSERT INTO OrdenPPT (idOrden, codReceta, cantidad) VALUES
  (1, 1, 100),
  (2, 1, 500),
  (3, 2, 2),
  (4, 3, 20),
  (5, 4, 50);
