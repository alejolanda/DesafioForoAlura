INSERT INTO topicos (titulo, mensaje, fecha_creacion,
                     estado, autor_id, curso_id)
SELECT 'Mi primer tópico', 'Tengo una duda sobre Spring Boot',
       NOW(), 'NO_RESPONDIDO', 1, 1
WHERE NOT EXISTS (
    SELECT 1 FROM topicos WHERE titulo = 'Mi primer tópico'
);