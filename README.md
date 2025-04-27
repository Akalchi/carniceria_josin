Backend Java con Spring Boot y Basic Auth
=========================================

Este proyecto es un backend desarrollado en Java con Spring Boot que implementa autenticación básica (Basic Auth) para proteger los endpoints de la API. Utiliza MySQL como base de datos principal para gestionar los productos de una carnicería.

Requisitos previos
------------------

*   JDK 17 o superior
    
*   Maven 3.6+
    
*   MySQL 8.0+
    
*   IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code, etc.)
    

Tecnologías utilizadas
----------------------

*   Spring Boot 3.2.x
    
*   Spring Security
    
*   Spring Data JPA
    
*   MySQL
    
*   Maven
    

Configuración inicial
---------------------

1.  bashgit clone https://github.com/tu-usuario/carniceria\_josin.gitcd carniceria\_josin
    
2.  Configura tu base de datos MySQL:
    
    *   sqlCREATE DATABASE carniceria\_josin;
        
    *   Asegúrate de que los datos de conexión en application.properties coincidan con tu instalación de MySQL
        
3.  bashmvn clean install
    
4.  bashmvn spring-boot:run
    

El servidor se iniciará en http://localhost:8080

Estructura del proyecto
-----------------------
```src/
├── main/
│   ├── java/
│   │   └── dev/alejandra/carniceria_josin/
│   │       ├── config/           # Configuraciones de Spring
│   │       ├── product/          # Controladores y entidades de productos
│   │       │   ├── Product.java
│   │       │   ├── ProductController.java
│   │       │   └── ProductRepository.java
│   │       ├── security/         # Configuración de seguridad
│   │       ├── service/          # Servicios
│   │       └── Application.java  # Clase principal
│   └── resources/
│       ├── application.properties # Propiedades de la aplicación
│       └── data.sql              # Script SQL inicial (opcional)
└── test/                         # Pruebas unitarias e integración
```
Configuración de la seguridad
-----------------------------

La autenticación básica está configurada en el archivo SecurityConfig.java. Por defecto, se crea un usuario para pruebas:

*   **Usuario**: admin
    
*   **Contraseña**: password
    
Endpoints disponibles
---------------------
| Método | URL                     | Descripción                        | Acceso      |
|--------|-------------------------|------------------------------------|-------------|
| GET    | `/api/products`         | Obtener todos los productos        | Autenticado |
| GET    | `/api/products/{id}`    | Obtener un producto por ID         | Autenticado |
| POST   | `/api/products`         | Crear un nuevo producto            | Autenticado |
| PUT    | `/api/products/{id}`    | Actualizar un producto existente   | Autenticado |
| DELETE | `/api/products/{id}`    | Eliminar un producto               | Autenticado |

Ejemplo de objeto Producto
--------------------------
```json
{
  "id": 1,
  "name": "Bistec de res",
  "category": "CARNE_RES",
  "priceKg": 180.50,
  "stockKg": 25.5
}
```

Configuración personalizada
---------------------------
Puedes modificar las propiedades de la aplicación en el archivo `application.properties`:
## Configuración personalizada

Puedes modificar las propiedades de la aplicación en el archivo `application.properties`:
```properties
# Puerto del servidor
server.port=8080

# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/carniceria_josin
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de la zona horaria
spring.jackson.time-zone=Europe/Madrid
```
Dependencia de MySQL en pom.xml
-------------------------------
## Dependencia de MySQL en `pom.xml`

Asegúrate de incluir la dependencia de MySQL en tu archivo `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```
