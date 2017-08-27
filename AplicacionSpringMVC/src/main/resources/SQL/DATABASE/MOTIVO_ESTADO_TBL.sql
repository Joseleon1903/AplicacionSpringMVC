 /*-----------------------------MOTIVO_ESTADO------------------------------*/ 
  
   CREATE TABLE `aplicacion_web_rest`.`motivo_estado` (
  `MOTIVO_ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(255) NOT NULL,
  `ESTADO` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`MOTIVO_ID`));