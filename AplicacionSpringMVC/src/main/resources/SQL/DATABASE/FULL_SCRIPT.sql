 /* -----------------------------SCHEMA------------------------------*/
  /** ----------- SCRIPT CREACION AMBIENTE BASE DE DATO---------------**/
   /* -----------------------------SCHEMA------------------------------*/


CREATE SCHEMA `aplicacion_web_rest` ;


  /*-----------------------------MOTIVO_ESTADO------------------------------*/ 
  
   CREATE TABLE `aplicacion_web_rest`.`motivo_estado` (
  `MOTIVO_ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(255) NOT NULL,
  `ESTADO` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`MOTIVO_ID`));
  
    /*-----------------------------DETALLE_CONTACTO------------------------------*/

  CREATE TABLE `aplicacion_web_rest`.`DETALLE_CONTACTO` (
  `DETALLE_CONTACTO_ID` INT NOT NULL AUTO_INCREMENT,
  `EMAIL_ALTERNATIVA` VARCHAR(50) NOT NULL,
  `DIRECCION` VARCHAR(255) NULL,
  `TELEFONO` VARCHAR(11) NULL,
  `CELULAR` VARCHAR(11) NULL,
  PRIMARY KEY (`DETALLE_CONTACTO_ID`));
  
  /*-----------------------------CONTACTO------------------------------*/
  
  CREATE TABLE `aplicacion_web_rest`.`contacto` (
  `CONTACTO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(25) NOT NULL,
  `APELLIDO` VARCHAR(25) NOT NULL,
  `SEXO` VARCHAR(1) NOT NULL,
  `FECHA_NACIMIENTO` DATETIME NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `DETALLE_CONTACTO_ID` INT NULL,
  `ESTADO` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`CONTACTO_ID`));
  
  ALTER TABLE `aplicacion_web_rest`.`contacto` 
  ADD INDEX `FK_CONTACTO_DETALLE_idx` (`DETALLE_CONTACTO_ID` ASC);
  ALTER TABLE `aplicacion_web_rest`.`contacto` 
  ADD CONSTRAINT `FK_CONTACTO_DETALLE`
  FOREIGN KEY (`DETALLE_CONTACTO_ID`)
  REFERENCES `aplicacion_web_rest`.`detalle_contacto` (`DETALLE_CONTACTO_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/*-----------------------------USUARIO------------------------------*/

CREATE TABLE `aplicacion_web_rest`.`usuario` (
  `USUARIO_ID` INT NOT NULL AUTO_INCREMENT,
  `CODIGO_USUARIO` VARCHAR(12) NOT NULL,
  `PASSWORD` VARCHAR(12) NOT NULL,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ULTIMO_ACCESO` DATETIME NULL,
  `CONTACTO_ID` INT NOT NULL,
  PRIMARY KEY (`USUARIO_ID`));
  
 ALTER TABLE `aplicacion_web_rest`.`usuario` 
  ADD INDEX `FK_USUARIO_CONTACTO_idx` (`CONTACTO_ID` ASC);
 ALTER TABLE `aplicacion_web_rest`.`usuario` 
 ADD CONSTRAINT `FK_USUARIO_CONTACTO`
 FOREIGN KEY (`CONTACTO_ID`)
 REFERENCES `aplicacion_web_rest`.`contacto` (`CONTACTO_ID`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION;
 
 /*-----------------------------ENVIO_SISTEMA------------------------------*/ 
  
  CREATE TABLE `aplicacion_web_rest`.`envio_sistema` (
  `ENVIO_ID` INT NOT NULL AUTO_INCREMENT,
  `FECHA_ENVIO` DATETIME NOT NULL,
  `ASUNTO` VARCHAR(25) NOT NULL,
  `DESTINATARIO` VARCHAR(25) NOT NULL,
  `CONTENIDO` VARCHAR(800) NULL,
  `ESTADO` VARCHAR(2) NOT NULL,
  `MOTIVO_ID` INT NULL,
  PRIMARY KEY (`ENVIO_ID`));
  
  ALTER TABLE `aplicacion_web_rest`.`envio_sistema` 
  ADD INDEX `FK_MOTIVO_ENVIO_idx` (`MOTIVO_ID` ASC);
  ALTER TABLE `aplicacion_web_rest`.`envio_sistema` 
  ADD CONSTRAINT `FK_MOTIVO_ENVIO`
  FOREIGN KEY (`MOTIVO_ID`)
  REFERENCES `aplicacion_web_rest`.`motivo_estado` (`MOTIVO_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  ALTER TABLE `aplicacion_web_rest`.`envio_sistema` 
  ADD CONSTRAINT CHK_ESTADO CHECK (`ESTADO` ='OK' OR `ESTADO` ='RE');
  
  /*-----------------------------EVENTO_SISTEMA------------------------------*/
	
  CREATE TABLE `aplicacion_web_rest`.`evento_sistema` (
  `EVENTO_SISTEMA_ID` INT NOT NULL AUTO_INCREMENT,
  `CONTACTO_ID` INT NOT NULL,
  `FECHA_EVENTO` DATETIME NOT NULL,
  `ENVIO_ID` INT NOT NULL,
  PRIMARY KEY (`EVENTO_SISTEMA_ID`));
  
  ALTER TABLE `aplicacion_web_rest`.`evento_sistema` 
  ADD INDEX `FK_EVENTO_ENVIO_idx` (`ENVIO_ID` ASC);
  ALTER TABLE `aplicacion_web_rest`.`evento_sistema` 
  ADD CONSTRAINT `FK_EVENTO_ENVIO`
  FOREIGN KEY (`ENVIO_ID`)
  REFERENCES `aplicacion_web_rest`.`envio_sistema` (`ENVIO_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;