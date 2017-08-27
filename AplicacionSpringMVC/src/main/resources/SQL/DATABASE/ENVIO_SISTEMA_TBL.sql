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