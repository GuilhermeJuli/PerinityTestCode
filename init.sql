-- Criação do banco de dados se ele não existir
DO $$
BEGIN
        IF NOT EXISTS (
            SELECT FROM pg_database WHERE datname = 'perinitytest'
        ) THEN
            EXECUTE 'CREATE DATABASE "perinitytest"';
END IF;
END
$$;

\c perinitytest


CREATE TABLE IF NOT EXISTS pessoa (
                                      id SERIAL PRIMARY KEY,
                                      nome VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS tarefa (
                                      id SERIAL PRIMARY KEY,
                                      titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    prazo DATE,
    departamento VARCHAR(100) NOT NULL,
    duracao INTEGER NOT NULL,
    finalizada BOOLEAN NOT NULL DEFAULT FALSE,
    pessoa_id INTEGER,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE SET NULL
    );

INSERT INTO pessoa (nome, departamento) VALUES
                                            ('João da Silva', 'TI'),
                                            ('Maria Oliveira', 'RH');

INSERT INTO tarefa (titulo, descricao, prazo, departamento, duracao, finalizada, pessoa_id) VALUES
                                                                                                ('Desenvolver API', 'Criar uma API REST para o gerenciamento de tarefas', '2024-09-15', 'TI', 20, FALSE, 1),
                                                                                                ('Revisar documentação', 'Revisar a documentação da API e fazer correções necessárias', '2024-09-10', 'TI', 10, TRUE, 1),
                                                                                                ('Planejar reunião', 'Planejar reunião com o time de desenvolvimento', '2024-09-05', 'RH', 5, FALSE, 2);
