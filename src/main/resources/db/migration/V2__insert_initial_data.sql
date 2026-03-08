-- Usuario de prueba (password: 123456)
INSERT INTO usuarios (nombre, email, password, created_at) VALUES
    ('Alejandro', 'alejandro@prueba.com',
     '$2a$10$Toqom0MP8n9vwnohQ.W5EOIktfxm/DodY7pmAeEQ1Bt2TWKRnr2Ue',
     NOW());

-- Cursos de prueba
INSERT INTO cursos (nombre, categoria) VALUES
      ('Spring Boot', 'Backend'),
      ('Java', 'Programación');