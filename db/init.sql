-- Criação da tabelacategory
CREATE TABLE category (
                           category_id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           description TEXT
);

-- Criação da tabela responsible
CREATE TABLE responsible (
                             responsible_id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL

);

-- Criação da tabela task
CREATE TABLE task (
                        task_id SERIAL PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        description TEXT,
                        data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(20) NOT NULL,
                       category_id INT REFERENCES category(category_id),
                        responsible_id INT REFERENCES responsible(responsible_id)
);

-- Inserção de dados emcategory
INSERT INTO category (name, description) VALUES
                                            ('Limpeza', 'Tarefas relacionadas à limpeza da casa'),
                                            ('Administração', 'Pagamentos, contas, etc'),
                                            ('Compras', 'Compra de mantimentos e itens essenciais'),
                                            ('Manutenção', 'Pequenos reparos e ajustes'),
                                            ('Cozinha', 'Preparar alimentos'),
                                            ('Organização', 'Organização de ambientes e itens');

-- Inserção de dados em responsible
INSERT INTO responsible (name) VALUES
                                                    ('Victor'),
                                                    ('Maria'),
                                                    ('Carlos'),
                                                    ('Ana'),
                                                    ('José'),
                                                    ('Julia');

-- Inserção de dados em task
INSERT INTO task (title, description, status,category_id, responsible_id) VALUES
                                                                                 ('Limpar banheiro', 'Limpeza completa do banheiro', 'PENDENTE', 1, 1),
                                                                                 ('Pagar conta de luz', 'Vencimento dia 10', 'PENDENTE', 2, 2),
                                                                                 ('Comprar arroz', '2kg de arroz integral', 'CONCLUIDA', 3, 3),
                                                                                 ('Consertar torneira', 'Torneira da cozinha está vazando', 'PENDENTE', 4, 4),
                                                                                 ('Preparar almoço', 'Fazer almoço para a família', 'CONCLUIDA', 5, 5),
                                                                                 ('Organizar armário', 'Separar roupas para doação', 'PENDENTE', 6, 6);
