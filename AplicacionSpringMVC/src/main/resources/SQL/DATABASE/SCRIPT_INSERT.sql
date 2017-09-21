 /* -----------------------------SCHEMA------------------------------*/
/*---------------------INSERT INILICIALIZACION CATALOGO Y USUARIO ---------------------*/
 /* -----------------------------SCHEMA------------------------------*/


/* ------------------MOTIVO_ESTADO INSERT ---------*/
insert into motivo_estado(motivo_id , descripcion, estado)
values(500, upper('[Internal Server Error] Error Interno en el Servidor.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(505, upper('[Internal Server Error] por favor contactar el administrador.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(404, upper('[NOT FOUND  ERROR] Objeto solicitado no encontrado.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(405, upper('[NOT FOUND  Connection] no fue posible establecer la conexión'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(501, upper('[Internal Server Error] Permisos de ejecución Incorrectos.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(502, upper('[Invalid User Error] Error en el inicio de sesión del servicio de perfil de usuario.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(503, upper('[NOT FOUND  OBJECT] Existen datos requeridos no porporcionados.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(504, upper('[Invalid OBJECT ERROR] Atención Las passwords deben de coincidir.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(801, upper('[DUPLICATE OBJECT ERROR] el objeto se encuentra duplicado.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(802, upper('[DUPLICATE OBJECT ERROR] el username del nuevo usuario se encuentra ya registrado.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(1909, upper('[CREATE OBJECT ERROR] existen datos Requerido no proporcionados.'), 'AC');
insert into motivo_estado(motivo_id , descripcion, estado)
values(1919, upper('[Invalid OBJECT ERROR] el campo se encuentra fuera del rango permitido.'), 'AC');

/* ------------------CONTACTO INSERT ---------*/
INSERT INTO CONTACTO (CONTACTO_ID,NOMBRE,APELLIDO,SEXO, FECHA_NACIMIENTO,EMAIL, DETALLE_CONTACTO_ID,ESTADO)
 VALUES(1, 'ALBERTO', 'SANCHEZ', 'M', SYSDATE(), 'JOSELEON1903@OUTLLOK.COM', NULL, 'AC');

/* ------------------USUARIO INSERT ---------*/
INSERT INTO USUARIO(USUARIO_ID,CODIGO_USUARIO,PASSWORD,FECHA_CREACION,FECHA_ULTIMO_ACCESO,CONTACTO_ID) 
VALUES(1,'ADMIN', 'ADMIN123', SYSDATE(), NULL, 1);

 