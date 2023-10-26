# Mi Proyecto Spring

Este proyecto utiliza una variedad de tecnologías para desarrollar una aplicación con Spring. A continuación se detallan las principales tecnologías y herramientas utilizadas:

## Tecnologías Principales
- Java 17: Utilizamos la última versión de Java para aprovechar sus características y mejoras.

- Spring Framework: Esta aplicación está construida con el ecosistema de Spring, incluyendo Spring Boot, Spring Data JPA y Spring Validation.

- MySQL con Docker Compose: Utilizamos Docker Compose para orquestar un contenedor de MySQL, que sirve como nuestra base de datos principal.

- Hibernate ORM: Hibernate se utiliza para mapear objetos Java a las tablas de la base de datos y realizar operaciones de base de datos.

- MapStruct: Esta biblioteca se utiliza para simplificar el mapeo entre objetos DTO y entidades de base de datos.

- Lombok: Lombok nos ayuda a reducir la verbosidad del código generando automáticamente getters, setters y otros métodos.

- Spring cloud client: para dejar el camino a consumir el archivo de configuracion desde un server configuration.

- H2 para Pruebas de Integración: Para las pruebas de integración, aprovechamos H2, una base de datos en memoria que facilita las pruebas.

## Configuración y Uso
Asegúrese de seguir los siguientes pasos para configurar y ejecutar la aplicación:

1. **Requisitos Previos**: Asegúrese de tener instalado Java 17 y Docker en su sistema.

2. **Docker Compose**: Utilice Docker Compose para levantar el contenedor de MySQL con la configuración adecuada.

3. **Compilación y Ejecución**: Utilice su entorno de desarrollo preferido para compilar y ejecutar la aplicación Spring.

4. **Variables de entorno**: Asegurese de definir las variables de entorno en el sistema para encapsular los datos del archivo de configuración. 

## Contribución
¡Estamos abiertos a contribuciones! Si desea contribuir al proyecto, no dude en realizar un _fork_ y enviar sus _pull requests_.

Esperamos que esta aplicación sea útil y que disfrute trabajando con ella.

## Licencia
Este proyecto se distribuye bajo la [Licencia MIT](LICENSE).
