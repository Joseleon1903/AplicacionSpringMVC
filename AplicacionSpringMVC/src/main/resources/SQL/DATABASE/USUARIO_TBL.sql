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