-- V2__insert_initial_data.sql

-- Insertar cursos de prueba
INSERT INTO cursos (nombre, categoria) VALUES
       ('Spring Boot', 'Backend'),
       ('Java', 'Programación');

-- Insertar usuario de prueba
-- Password: 123456 (hash BCrypt válido)
INSERT INTO usuarios (nombre, email, password, created_at) VALUES
    ('Alejandro', 'alejandro@prueba.com',
     '$2a$10$Toqom0MP8n9vwnohQ.W5EOIktfxm/DodY7pmAeEQ1Bt2TWKRnr2Ue',
     NOW());