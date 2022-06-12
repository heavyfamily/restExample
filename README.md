# restExample
This is the backend deplotment maked with Sprint Framework + MySQL (JPA). This deploitment simulate a co


Desarrollar una aplicación utilizando Java 8 o 11 y Spring Framework para exponer las 
siguientes operaciones a través de servicios RestFul. Es necesario que las informaciones sean 
persistidas, utilizando una BBDD para almacenar la información.

Entidades:
  • Cursos
    o Nombre -texto
    o Fecha de inicio –fecha y hora
    o Fecha fin - fecha y hora
    o Número máximo de alumnos - numero
    o Fecha de registro – fecha y hora
  • Alumnos
    o Nombre -texto
    o Apellido – texto
    o Numero de documento -texto
    o Fecha de nacimiento - fecha
    o Fechade registro - fecha y hora
  • Curso alumno
    o Fecha de inscripción – fecha y hora
    o Fecha de baja – fecha y hora
    
Operaciones: 
  • Curso
    o Añadir
    o Actualizar
    o Borrar
    o Consultar por id
    o Consultar todos
    o Consultar cursos por nombre
    o Opcional
      ▪ Consultar cursos por fecha inicio
      ▪ Consultar cursos por fecha fin
  • Alumno
    o Añadir
    o Actualizar
    o Borrar
    o Consultar por id
    o Consultar Todos
    o Consultar por nombre
    o Opcional
      ▪ Consultar alumno por fecha de nacimiento
  • Curso alumno
    o Dar de alta un alumno a uno o más cursos.
    o Quitar un alumno de un curso
    o Consultar alumnos por curso
    o Opcional
      ▪ Consultar cumpleaños por curso 
Validaciones:
  • Curso:
    o Nombre requerido y al menos 3 caracteres validos (ejemplo nombre 
    invalido: “ A ”)
    o Cantidad máxima de alumnos: requerido y numero valido y superior a 0
    o Fecha inicio requerida y posterior a la fecha actual
    o Fecha fin requerida y no puede ser antes a la fecha de inicio 
    o No permitir borrar un curso que tenga uno o más alumnos
      o Opcional
        ▪ No permitir duplicidad de alumno
        ▪ No permitir exceder el numero de alumnos al curso según su 
        cantidad máxima de alumnos
        ▪ No permitir duplicidad de un curso
  • Alumno
    o Nombre requerido y al menos 3 caracteres validos (ejemplo nombre 
    invalido: “ A ”)
    o Apellido requerido y al menos 2 caracteres validos (ejemplo nombre 
    invalido: “ A ”)
    o Fecha nacimiento requerida y debe ser mayor de edad
    o No permitir duplicidad de alumno
      Opcional
        • Aplicar paginación en los resultados de operaciones que retornen una lista de 
        objetos. 
        • Aplicar seguridad en las operacione
