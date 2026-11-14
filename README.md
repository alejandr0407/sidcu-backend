# SIDCU - Backend | Simulador de Carreras Universitarias

<p align="center">
  <img width="500" alt="SIDCU" src="https://github.com/user-attachments/assets/1331825e-9657-4e2d-ad47-83a672ea304a" />
</p>

<p align="center">
  API REST desarrollada con Java y Spring Boot para gestionar la información, los usuarios, las carreras universitarias y las instituciones educativas de la plataforma SIDCU.
</p>

---

## Descripción del proyecto

**SIDCU (Simulador de Carreras Universitarias)** es una plataforma web de orientación vocacional diseñada para ayudar a estudiantes de secundaria y personas interesadas en iniciar su formación profesional a explorar diferentes alternativas académicas.

Este repositorio contiene el desarrollo del backend de la aplicación, encargado de gestionar la lógica del sistema, procesar las solicitudes del frontend, administrar la información y establecer la conexión con la base de datos.

El backend proporciona servicios mediante una API REST, permitiendo la comunicación entre el frontend y la base de datos.

## Características principales

- **Gestión de usuarios:** administración de usuarios y funcionalidades de autenticación.
- **Autenticación y seguridad:** implementación de Spring Security y tokens JWT.
- **Gestión de carreras:** consulta y administración de información de programas académicos.
- **Gestión de universidades:** almacenamiento y consulta de instituciones educativas.
- **Persistencia de datos:** conexión y gestión de información mediante Spring Data JPA.
- **API REST:** servicios para la comunicación con el frontend.
- **Documentación de API:** integración con SpringDoc y Swagger UI.

## Tecnologías utilizadas

### Backend
- Java 17
- Spring Boot 4.1.1
- Maven
- Lombok

### Base de datos
- PostgreSQL
- Neon (alojamiento de base de datos)

## Arquitectura del proyecto

SIDCU está dividido en dos repositorios independientes que trabajan conjuntamente:

| Componente | Tecnología | Repositorio |
|---|---|---|
| Frontend | React, JavaScript y Vite | [SIDCU Frontend](https://github.com/samuelmc-12/SidcuReact.git) |
| Backend | Java y Spring Boot | Este repositorio |
| Base de datos | PostgreSQL | Neon |

## Requisitos previos

Para ejecutar el backend localmente necesitas:

- Java JDK 17.
- Maven (opcional, el proyecto incluye Maven Wrapper).
- PostgreSQL o acceso a la base de datos configurada en Neon.
- Visual Studio Code o IntelliJ IDEA.
- Postman (opcional, para probar los servicios).

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/alejandr0407/sidcu-backend.git
```

### 2. Ingresar a la carpeta

```bash
cd sidcu-backend
```

### 3. Configurar las variables de entorno

El proyecto utiliza variables de entorno para establecer la conexión con PostgreSQL y configurar la autenticación JWT.

Debes configurar las siguientes variables:

| Variable | Descripción |
|---|---|
| DB_URL | Dirección de conexión a PostgreSQL |
| DB_USERNAME | Usuario de la base de datos |
| DB_PASSWORD | Contraseña de la base de datos |
| JWT_SECRET | Clave secreta para JWT |
| JWT_EXPIRATION | Tiempo de expiración del token |
| PORT | Puerto de ejecución del servidor |

Ejemplo de configuración:

```properties
DB_URL=jdbc:postgresql://TU_HOST/neondb?sslmode=require&channel_binding=require
DB_USERNAME=TU_USUARIO
DB_PASSWORD=TU_CONTRASEÑA
JWT_SECRET=TU_CLAVE_SECRETA
JWT_EXPIRATION=86400000
PORT=8080
```

**Importante:** reemplaza los valores de ejemplo por tus propias credenciales. No publiques contraseñas, claves JWT ni información sensible en GitHub.

Las variables deben estar configuradas en el entorno del sistema o en la plataforma de despliegue. El archivo `.env` por sí solo no es cargado automáticamente por Spring Boot.

### 4. Compilar el proyecto

En Windows:

```powershell
.\mvnw.cmd clean package -DskipTests
```

En Linux o macOS:

```bash
./mvnw clean package -DskipTests
```

### 5. Ejecutar el backend

En Windows:

```powershell
java -jar target\sidcudb-0.0.1-SNAPSHOT.jar
```

En Linux o macOS:

```bash
java -jar target/sidcudb-0.0.1-SNAPSHOT.jar
```

Por defecto, el servidor se ejecuta en el puerto 8080, siempre que no se configure otro puerto.

### 6. Verificar el funcionamiento

Una vez iniciado el servidor, puedes acceder a la documentación de la API mediante:

```text
http://localhost:8080/swagger-ui/index.html
```

También puedes utilizar Postman para realizar solicitudes y comprobar el funcionamiento de los diferentes servicios.

## Base de datos

SIDCU utiliza PostgreSQL como sistema de gestión de bases de datos.

La base de datos se encuentra alojada en Neon, permitiendo almacenar y consultar la información necesaria para el funcionamiento de la plataforma.

La comunicación con la base de datos se realiza mediante:

- Spring Data JPA.
- Hibernate.
- PostgreSQL JDBC Driver.

Las credenciales de conexión se administran mediante variables de entorno para proteger la información sensible.

## Despliegue

El backend está preparado para ejecutarse como una aplicación Spring Boot empaquetada en formato JAR.

Para su despliegue en servicios como Render se deben configurar las variables de entorno necesarias:

- DB_URL
- DB_USERNAME
- DB_PASSWORD
- JWT_SECRET
- JWT_EXPIRATION
- PORT

La plataforma de despliegue debe contar con Java compatible con el proyecto y acceso a la base de datos Neon.

## Estado del proyecto

**En desarrollo.**

Actualmente se trabaja en la integración de los servicios del backend con el frontend de SIDCU, la implementación de las funcionalidades principales, la autenticación de usuarios y la conexión con la base de datos PostgreSQL.

## Autores

- Alejandra Meza
- Samuel Muñoz

---

<p align="center">
  <strong>SIDCU - Explora tus posibilidades, construye tu futuro.</strong>
</p>
