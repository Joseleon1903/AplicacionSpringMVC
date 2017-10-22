/* 
 * 
 * Creando funcion para optener el proxiomo valor del indice de una tabla.
 * 
 */
DELIMITER $$

CREATE FUNCTION optenerValorIndexTabla ( p_nombre_tabla VARCHAR(10) ) RETURNS INT(11)
BEGIN

    DECLARE _schema VARCHAR(20);  
	DECLARE _index INT(11);
    
    SET _schema = 'aplicacion_web_rest';
    
    SELECT auto_increment INTO _index FROM `information_schema`.tables WHERE TABLE_SCHEMA = _schema 
	AND TABLE_NAME = p_nombre_tabla;

    RETURN _index;
    
END;
$$
DELIMITER ;