CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cursos (
                        id BIGSERIAL PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        categoria VARCHAR(50) NOT NULL
);

CREATE TABLE topicos (
                         id BIGSERIAL PRIMARY KEY,
                         titulo VARCHAR(150) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         estado VARCHAR(20) NOT NULL DEFAULT 'NO_RESPONDIDO',
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                         CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES cursos(id),
                         CONSTRAINT uk_topico_titulo_mensaje UNIQUE (titulo, mensaje)
);