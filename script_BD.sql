CREATE TABLE categorias (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    estado boolean NOT NULL
);

CREATE TABLE articulos (
    id integer NOT NULL,
    nombre character varying(80) NOT NULL,
    descripcion text,
    estado boolean DEFAULT true
);

CREATE TABLE unidades (
    id integer NOT NULL,
    nombre character varying(20) NOT NULL,
    abreviado character varying(20) NOT NULL
);

CREATE TABLE inventario (
    id integer NOT NULL,
    idarticulo integer NOT NULL,
    idcategoria integer NOT NULL,
    idunidad integer NOT NULL,
    stock numeric(20,2) DEFAULT 0 NOT NULL,
    stockmin integer NOT NULL,
    stockmax integer NOT NULL,
    fechavencimiento date NOT NULL,
	estado boolean DEFAULT true
);

CREATE TABLE imagenes (
    id integer NOT NULL,
    url text NOT NULL,
    idinventario integer NOT NULL
);
-- MODIFICACION DE LAS TABLAS
ALTER TABLE `clinica`.`articulos` 

ADD PRIMARY KEY (`id`) ;


ALTER TABLE `clinica`.`categorias` CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT  

, ADD PRIMARY KEY (`id`) ;


ALTER TABLE `clinica`.`imagenes` 

  ADD CONSTRAINT `idInventario`

  FOREIGN KEY (`id` )

  REFERENCES `clinica`.`inventario` (`id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION

, ADD PRIMARY KEY (`id`) 

, ADD INDEX `idInventario_idx` (`id` ASC) ;


ALTER TABLE `clinica`.`unidades` CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT  

, ADD PRIMARY KEY (`id`) ;


ALTER TABLE `clinica`.`inventario` 

  ADD CONSTRAINT `CATEGORIA`

  FOREIGN KEY (`idcategoria` )

  REFERENCES `clinica`.`categorias` (`id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION, 

  ADD CONSTRAINT `UNIDAD`

  FOREIGN KEY (`idunidad` )

  REFERENCES `clinica`.`unidades` (`id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION

, ADD INDEX `CATEGORIA_idx` (`idcategoria` ASC) 

, ADD INDEX `UNIDAD_idx` (`idunidad` ASC) ;

ALTER TABLE `clinica`.`inventario` 

  ADD CONSTRAINT `ARTICULO`

  FOREIGN KEY (`idarticulo` )

  REFERENCES `clinica`.`articulos` (`id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION

, ADD INDEX `ARTICULO_idx` (`idarticulo` ASC) ;

-- INSERCION DE DATOS
--
INSERT INTO categorias VALUES (1, 'Agentes inmunosupresores', true);
INSERT INTO categorias VALUES (2, 'Antibióticos', true);
INSERT INTO categorias VALUES (3, 'Ansiolítico', true);
INSERT INTO categorias VALUES (4, 'Fármaco', true);
INSERT INTO categorias VALUES (5, 'Suplemento dietético', true);
INSERT INTO categorias VALUES (6, 'Suplemento vitamínico', true);
INSERT INTO categorias VALUES (7, 'Sustancia placebo', true);

--
--
INSERT INTO articulos VALUES (1, 'Aspirina Forte de Bayer','Para la migraña',true);
INSERT INTO articulos VALUES (2, 'Ibuprofeno', 'Para los dolores de cabeza o jaqueca cotidianos',true);
INSERT INTO articulos VALUES (3, 'Metocarbamol 500mg', 'Para los dolores muculares recurrentes',true);
--
--
INSERT INTO unidades VALUES (1, 'Caja', 'Cj');
--
--
INSERT INTO inventario VALUES (1, 1, 2, 1, 52.00, 50, 500, '2020-07-31',true);
INSERT INTO inventario VALUES (2, 2, 7, 1, 52.00, 52, 5000, '2019-07-27', true);
INSERT INTO inventario VALUES (3, 3, 2, 1, 52.00, 500, 0, '2020-04-30', false);
--
--
INSERT INTO imagenes VALUES (1, 'C:\Users\gerardo\Documents\NetBeansProjects\ClinicaE_MEA\src\Recursos\Productos\141fe_aspirina_thumb.jpg', 3);

CREATE  TABLE `clinica`.`rol` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) );

INSERT INTO `clinica`.`rol` (`id`, `nombre`, `descripcion`) VALUES ('1', 'Administrador', 'Administra y configura el Sistema');
INSERT INTO `clinica`.`rol` (`id`, `nombre`, `descripcion`) VALUES ('2', 'Usuario', 'Puede registrar y consultar registros');

CREATE  TABLE `clinica`.`usuario` (
  `id` INT NOT NULL ,
  `nombres` VARCHAR(50) NULL ,
  `apellidos` VARCHAR(50) NULL ,
  `usuario` VARCHAR(45) NOT NULL ,
  `clave` VARCHAR(45) NOT NULL ,
  `codrol` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `ROL_idx` (`id` ASC) ,
  CONSTRAINT `ROL`
    FOREIGN KEY (`id` )
    REFERENCES `clinica`.`rol` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `clinica`.`usuario` (`id`, `nombres`, `apellidos`, `usuario`, `clave`, `codrol`) VALUES ('1', 'Pastor', '', 'gerard', '1234', '1');
INSERT INTO `clinica`.`usuario` (`id`, `nombres`, `usuario`, `clave`, `codrol`) VALUES ('2', 'Gerardo', 'darkps', 'admin', '2');
