-- V1__create_tables.sql
CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cursos (
                        id BIGSERIAL PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL,
                        categoria VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
                         id BIGSERIAL PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         estado VARCHAR(50) CHECK (estado IN ('NO_RESPONDIDO', 'NO_SOLUCIONADO', 'SOLUCIONADO', 'CERRADO')),
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);