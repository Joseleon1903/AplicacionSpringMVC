/*----------------insert 1 ---------------------*/
INSERT INTO envio_sistema (ENVIO_ID, FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO) 
VALUES (1, sysdate(), 'prueba 1', 'PRUEBA@GMAIL.COM', 'TEXTO DE PRUEBA CONFIRMANDO EXPACION.', 'OK');
INSERT INTO evento_sistema (EVENTO_SISTEMA_ID, CONTACTO_ID,FECHA_EVENTO, ENVIO_ID) VALUES (1, 1,sysdate(), 1);
/*----------------insert 2---------------------*/
INSERT INTO envio_sistema (ENVIO_ID, FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO) 
VALUES (2, sysdate(), 'prueba 1', 'PRUEBA@GMAIL.COM', 'TEXTO DE PRUEBA CONFIRMANDO EXPACION.', 'OK');
INSERT INTO evento_sistema (EVENTO_SISTEMA_ID, CONTACTO_ID,FECHA_EVENTO, ENVIO_ID) VALUES (2, 1,sysdate(), 2);
/*----------------insert 3---------------------*/
INSERT INTO envio_sistema (ENVIO_ID, FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO) 
VALUES (3, sysdate(), 'prueba 1', 'PRUEBA@GMAIL.COM', 'TEXTO DE PRUEBA CONFIRMANDO EXPACION.', 'OK');
INSERT INTO evento_sistema (EVENTO_SISTEMA_ID, CONTACTO_ID,FECHA_EVENTO, ENVIO_ID) VALUES (3, 1,sysdate(), 3);
/*----------------insert 4---------------------*/
INSERT INTO envio_sistema (ENVIO_ID, FECHA_ENVIO, ASUNTO, DESTINATARIO, CONTENIDO, ESTADO) 
VALUES (4, sysdate(), 'prueba 1', 'PRUEBA@GMAIL.COM', 'TEXTO DE PRUEBA CONFIRMANDO EXPACION.', 'OK');
INSERT INTO evento_sistema (EVENTO_SISTEMA_ID, CONTACTO_ID,FECHA_EVENTO, ENVIO_ID) VALUES (4, 1,sysdate(), 4);
