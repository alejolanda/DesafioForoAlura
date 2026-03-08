![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-7.0.3-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-11.14.1-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-0.12.5-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-1.18.42-pink?style=for-the-badge&logo=lombok&logoColor=white)
![Hibernate](https://badgen.net/badge/icon/hibernate?icon=hibernate&label)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

# 🗣️ Foro Hub — API REST

API REST de un foro desarrollada con **Spring Boot 4.0.3**, **Java 25** y **PostgreSQL 18**, como parte del desafío Alura ONE.

---

## 📋 Descripción

Foro Hub permite a usuarios autenticados crear, listar, actualizar y eliminar tópicos de discusión. Implementa seguridad mediante **JWT (JSON Web Tokens)** y sigue las buenas prácticas REST. El esquema de base de datos es gestionado completamente por **Flyway**.

---

## 🚀 Tecnologías utilizadas
| Tecnología | Versión |
|---|---|
| Java | 25 |(https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
| Spring Boot | 4.0.3 |[Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
| Spring Security | 7.0.3 |![Spring Security](https://img.shields.io/badge/Spring%20Security-7.0.3-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
| PostgreSQL | 18 |![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-316192?style=for-the-badge&logo=postgresql&logoColor=white)
| Hibernate | 7.2.4 |![Hibernate](https://badgen.net/badge/icon/hibernate?icon=hibernate&label)
| Flyway | 11.14.1 |![Flyway](https://img.shields.io/badge/Flyway-11.14.1-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
| JWT (jjwt) | 0.12.5 |![JWT](https://img.shields.io/badge/JWT-0.12.5-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
| Lombok | 1.18.42 |![Lombok](https://img.shields.io/badge/Lombok-1.18.42-pink?style=for-the-badge&logo=lombok&logoColor=white)
| SpringDoc OpenAPI | 2.3.0 |![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)|
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)


---

## ⚙️ Requisitos previos

- Java 25+
- Maven 3.x
- PostgreSQL 18

---

## 🗄️ Configuración de la base de datos

1. Crear la base de datos en PostgreSQL:

```sql
CREATE DATABASE forohub_db;
```

Las tablas y datos iniciales son creados automáticamente por Flyway al iniciar la aplicación.

**Migraciones incluidas:**

| Migración | Descripción |
|---|---|
| V1 | Creación de tablas (`usuarios`, `cursos`, `topicos`) |
| V2 | Usuario y cursos de prueba |
| V3 | Tópico inicial de prueba |

---

## 🔧 Configuración del proyecto

En `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/forohub_db
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}
```

Establece la variable de entorno `DB_PASSWORD` con tu contraseña de PostgreSQL:

- **Windows:** `set DB_PASSWORD=tu_password`
- **Linux/Mac:** `export DB_PASSWORD=tu_password`

---

## ▶️ Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/DesafioForoAlura.git

# Entrar al directorio
cd DesafioForoAlura

# Ejecutar
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

Al iniciar, Flyway ejecutará automáticamente las migraciones y creará las tablas con datos de prueba.

---

## 🔐 Autenticación

La API usa JWT. Para acceder a los endpoints protegidos:

1. Haz login para obtener el token
2. Incluye el token en el header: `Authorization: Bearer <token>`

El token expira en **1 hora**.

---

## 📡 Endpoints

### Autenticación

| Método | Endpoint | Descripción | Auth |
|---|---|---|---|
| POST | `/auth/login` | Login y obtención de token JWT | ❌ |

**Body:**
```json
{
    "email": "alejandro@prueba.com",
    "password": "123456"
}
```

**Respuesta:**
```json
{
    "token": "eyJhbGciOiJIUzM4NCJ9..."
}
```

---

### Tópicos

| Método | Endpoint | Descripción | Auth | Status |
|---|---|---|---|---|
| GET | `/topicos` | Listar todos los tópicos | ❌ | 200 |
| GET | `/topicos/{id}` | Obtener detalle de un tópico | ❌ | 200 |
| POST | `/topicos` | Crear un nuevo tópico | ✅ | 201 |
| PUT | `/topicos/{id}` | Actualizar un tópico | ✅ | 200 |
| DELETE | `/topicos/{id}` | Eliminar un tópico | ✅ | 204 |

---

**Body POST `/topicos`:**
```json
{
    "titulo": "Mi primer tópico",
    "mensaje": "Tengo una duda sobre Spring Boot",
    "autorId": 1,
    "cursoId": 1
}
```

**Body PUT `/topicos/{id}`:**
```json
{
    "titulo": "Título actualizado",
    "mensaje": "Mensaje actualizado",
    "estado": "RESPONDIDO"
}
```

**Estados disponibles:**
- `NO_RESPONDIDO`
- `RESPONDIDO`
- `CERRADO`

---

## 🧪 Datos de prueba

Cargados automáticamente por Flyway al iniciar:

**Usuario:**
```
Email:    alejandro@prueba.com
Password: 123456
```

**Cursos disponibles:**
- Spring Boot (id: 1)
- Java (id: 2)

**Tópico inicial:** id 1

---

## 📖 Documentación interactiva

Con la aplicación corriendo, accede a Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

Usa el botón **Authorize** para ingresar el token JWT y probar los endpoints protegidos directamente desde el navegador.

---

## 📁 Estructura del proyecto

```
src/main/java/cl/pleiades/DesafioForoAlura/
├── DesafioForoAluraApplication.java  ← Bean Flyway configurado aquí
├── controller/
│   ├── AutenticacionController.java
│   ├── GlobalExceptionHandler.java
│   └── TopicoController.java
├── dto/
│   ├── auth/
│   │   ├── DatosAutenticacionDTO.java
│   │   └── DatosTokenDTO.java
│   └── topico/
│       ├── DatosActualizacionTopico.java
│       ├── DatosDetalleTopico.java
│       ├── DatosListadoTopico.java
│       └── DatosRegistroTopicos.java
├── model/
│   ├── Curso.java
│   ├── EstadoTopico.java
│   ├── Topico.java
│   └── Usuario.java
├── repository/
│   ├── CursoRepository.java
│   ├── TopicoRepository.java
│   └── UsuarioRepository.java
├── seguridad/
│   ├── SecurityFiltro.java
│   └── SegurityConfig.java
└── service/
    ├── AutenticacionService.java
    ├── TokenService.java
    └── TopicoService.java

src/main/resources/
├── application.properties
└── db/migration/
    ├── V1__create_tables.sql
    ├── V2__insert_initial_data.sql
    └── V3__insert_initial_topico.sql
```

---

## ⚠️ Nota técnica — Flyway en Spring Boot 4.x

Spring Boot 4.x requiere configuración manual de Flyway como bean para garantizar que las migraciones se ejecuten antes de la validación de Hibernate. Esto está implementado en `DesafioForoAluraApplication.java`.

---

## 👨‍💻 Autor

**Alejandro Landa Melo** — Desafío Alura ONE — Desafio del Foro -Grupo9 Go!!!!

---

## 📄 Licencia

Este proyecto fue desarrollado con fines educativos como parte del programa Alura ONE.
