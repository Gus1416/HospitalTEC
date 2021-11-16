USE db_hospitaltec;


SELECT * FROM db_hospitaltec.area;

INSERT INTO db_hospitaltec.area (nombre) VALUES ('Medicina General');
INSERT INTO db_hospitaltec.area (nombre) VALUES ('Dermatología');
INSERT INTO db_hospitaltec.area (nombre) VALUES ('Cirugía General');
INSERT INTO db_hospitaltec.area (nombre) VALUES ('Pediatría');




INSERT INTO db_hospitaltec.catalogo_diagnosticos(nombre) VALUES ('CLÍNICO');
INSERT INTO db_hospitaltec.catalogo_diagnosticos(nombre) VALUES ('LESIONAL');
INSERT INTO db_hospitaltec.usuario (cedula,password) VALUES ('2345','password');
INSERT INTO db_hospitaltec.paciente (cedula_paciente,nombre,fecha_nacimiento,tipo_sangre,nacionalidad,residencia) VALUES ('2345','Sebastián Córdoba','12-12-21','O+','Costarricense','Costa Rica');

INSERT INTO db_hospitaltec.catalogo_diagnosticos(nombre) VALUES ('PATOGENÉTICO');
INSERT INTO db_hospitaltec.catalogo_diagnosticos(nombre) VALUES ('SINTOMÁTICO');

INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('CIRUGÍA',3,'Medicamento'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('QUIMIOTERAPIA',2,'Cirugía'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('HIDROTERAPIA',1,'Curación'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('RADIOTERAPIA',5,'Sutura'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('FISIOTERAPIA',7,'Radiografía'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('FARMACOTERAPIA',6,'Ultrasonido'); 
INSERT INTO db_hospitaltec.catalogo_tratamientos(nombre,cantidad_dosis,tipo) VALUES ('ORTOPEDIA',8,'Quimioterapia'); 
 

INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (1,1);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (1,6);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (1,7);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (2,5);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (2,6);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (2,7);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (3,4);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (3,3);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (3,2);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (3,4);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (4,7);
INSERT INTO db_hospitaltec.diagnostico_tratamiento(id_diagnostico,id_tratamiento) VALUES (4,6);


SELECT db_hospitaltec.catalogo_diagnosticos.id_diagnostico,db_hospitaltec.catalogo_diagnosticos.nombre,
db_hospitaltec.catalogo_tratamientos.id_tratamiento,db_hospitaltec.catalogo_tratamientos.nombre,
db_hospitaltec.catalogo_tratamientos.cantidad_dosis, db_hospitaltec.catalogo_tratamientos.tipo
FROM db_hospitaltec.catalogo_diagnosticos,db_hospitaltec.diagnostico_tratamiento,db_hospitaltec.catalogo_tratamientos
WHERE db_hospitaltec.catalogo_diagnosticos.id_diagnostico=db_hospitaltec.diagnostico_tratamiento.id_diagnostico AND db_hospitaltec.catalogo_tratamientos.id_tratamiento
= db_hospitaltec.diagnostico_tratamiento.id_tratamiento AND
db_hospitaltec.catalogo_diagnosticos.nombre= 'ETIOLÓGICO' ;

INSERT INTO  db_hospitaltec.centro_atencion(nombre, ubicacion,capacidad,tipo_centro) VALUES ('Calderón Guardia','San José',200,'Masivo');






----------    CONSULTAS  ---------------------------------------------------------------------------------------------------

--- Diagnósticos asociados a un paciente:

SELECT * FROM cita_atencion, catalogo_diagnosticos WHERE cita_atencion.id_diagnostico = catalogo_diagnosticos.id_diagnostico;

--- Diagnósticos asociados a un paciente FILTRO nivel de diagnostico 
SELECT * FROM cita_atencion, catalogo_diagnosticos WHERE cita_atencion.id_diagnostico = catalogo_diagnosticos.id_diagnostico AND 
cita_atencion.nivel = 'Leve' AND cita_atencion.cedula_paciente= 2345 ;

--- Diágnosticos asociados a un paciente en un rango de fechas 
SELECT * FROM cita_atencion, catalogo_diagnosticos WHERE cita_atencion.id_diagnostico = catalogo_diagnosticos.id_diagnostico AND 
cita_atencion.fecha between '2021-03-17' and '2021-05-17'   AND cita_atencion.cedula_paciente= 2345;

--- Diagnósticos asociados a un paciente FILTRO nombre de diagnostico 
SELECT * FROM cita_atencion, catalogo_diagnosticos WHERE cita_atencion.id_diagnostico = catalogo_diagnosticos.id_diagnostico AND 
cita_atencion.nombreDiag = 'CLÍNICO' AND cita_atencion.cedula_paciente= 2345 ;

--- Tratamiento asociado a un paciente 

--- Tratamiento asociado a un paciente : Nombre de Tratamiento
SELECT * FROM cita_atencion, catalogo_tratamientos WHERE cita_atencion.id_tratamiento = catalogo_tratamientos.id_tratamiento
AND cita_atencion.cedula_paciente= 2345 AND nombreT= 'HIDROTERAPIA';

--- Tratamiento asociado a un paciente : Tipo de Tratamiento
SELECT * FROM cita_atencion, catalogo_tratamientos WHERE cita_atencion.id_tratamiento = catalogo_tratamientos.id_tratamiento
AND cita_atencion.cedula_paciente= 2345 AND tipo= 'Curación';

--- Tratamiento asociado a un paciente : Rango de fechas 
SELECT * FROM cita_atencion, catalogo_tratamientos WHERE cita_atencion.id_tratamiento = catalogo_tratamientos.id_tratamiento
AND cita_atencion.cedula_paciente= 2345 AND cita_atencion.fecha between '2021-03-17' and '2021-05-17' ;



--- Cantidad de citas registradas en el sistema


--- Cantidad de citas registradas en el sistema: Por  especialidad,

SELECT COUNT(*) FROM ( SELECT id_cita,cita.id_area,fecha_hora,observacion,estado_actual,cedula_paciente,nombre
FROM cita,area WHERE cita.id_area=area.id_area and area.nombre= 'Dermatología' ) as T;

--- Cantidad de citas registradas en el sistema: Por  rango de fechas,
SELECT COUNT(*) FROM ( SELECT id_cita,cita.id_area,fecha_hora,observacion,estado_actual,cedula_paciente,nombre
FROM cita,area WHERE cita.id_area=area.id_area and cita.fecha_hora between '2016-03-17' and '2021-05-17' ) as T;

--- Cantidad de citas registradas en el sistema: Por  estado,
SELECT COUNT(*) FROM ( SELECT id_cita,cita.id_area,fecha_hora,observacion,estado_actual,cedula_paciente,nombre
FROM cita,area WHERE cita.id_area=area.id_area and cita.estado_actual='ASIGNADA' ) as T;



--- Cantidad de Diagnosticos

---  Cantidad de Diagnosticos: Nivel de los diagnósticos 
SELECT COUNT(*) FROM (SELECT * FROM db_hospitaCantidad_Citas_EspecialidadCantidad_Citas_Estadoltec.cita_atencion WHERE cita_atencion.nivel= 'Grave') as T;

--- Cantidad de Diagnosticos: Por Paciente
SELECT COUNT(*) FROM (SELECT * FROM db_hospitaltec.cita_atencion WHERE cita_atencion.cedula_paciente= 2345) as T;













