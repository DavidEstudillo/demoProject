# Demo Project

Aplicación para la demostración de habilidades técnicas en el proceso de selección de Capitole Consulting.

En este proyecto Demo se ha creado una aplicación/servicio en Spring Boot que provee un Endpoint REST de consulta según se pedía en los requisitos. 
Se trata de un proyecto con arquitectura Maven en Java 11. La ejecución de la aplicación tras su importación debe hacerse mediante spring-boot:run. 

Una vez en ejecución: 

  - Cuenta con una base de datos en memoria que incluye la tabla PRICES aportada en los requisitos y que es accesible desde: (/h2)
  - El Endpoint REST de consulta requerido es accesible desde: (/prices/priceByDateProductAndBrand) con los parámetros:
      - applicationDate (formato "yyyy-MM-dd-HH.mm.ss")
      - productId (numérico)
      - brandId (numérico)
    
De este modo un ejemplo de llamada al Endpoint desde el navegador, una vez el proyecto se esté ejecutando en local mediante el puerto 8080 sería:

  - http://localhost:8080/prices/priceByDateProductAndBrand?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1

El proyecto incluye tests unitarios que han sido probados mediante JUnit con resultados esperados.

Los requisitos iniciales de este proyecto están en el fichero TestJava2020.txt
