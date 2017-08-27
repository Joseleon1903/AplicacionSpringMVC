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
  