-- Criação da tabelacategory
CREATE TABLE category (
                           category_id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           description TEXT,
                           ativo INT NOT NULL
);

-- Criação da tabela responsible
CREATE TABLE responsible (
                             responsible_id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             ativo INT NOT NULL
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
INSERT INTO category (name, description, ativo) VALUES
                                            ('Limpeza', 'Tarefas relacionadas à limpeza da casa', 1),
                                            ('Administração', 'Pagamentos, contas, etc', 1),
                                            ('Compras', 'Compra de mantimentos e itens essenciais', 1),
                                            ('Manutenção', 'Pequenos reparos e ajustes', 1),
                                            ('Cozinha', 'Preparar alimentos', 1),
                                            ('Organização', 'Organização de ambientes e itens', 1);

-- Inserção de dados em responsible
INSERT INTO responsible (name, ativo) VALUES
                                                    ('Victor', 1),
                                                    ('Maria', 1),
                                                    ('Carlos', 1),
                                                    ('Ana', 1),
                                                    ('José', 1),
                                                    ('Julia', 1);

-- Inserção de dados em task
INSERT INTO task (title, description, status,category_id, responsible_id) VALUES
                                                                                 ('Limpar banheiro', 'Limpeza completa do banheiro', 'PENDENTE', 1, 1),
                                                                                 ('Pagar conta de luz', 'Vencimento dia 10', 'PENDENTE', 2, 2),
                                                                                 ('Comprar arroz', '2kg de arroz integral', 'CONCLUIDA', 3, 3),
                                                                                 ('Consertar torneira', 'Torneira da cozinha está vazando', 'PENDENTE', 4, 4),
                                                                                 ('Preparar almoço', 'Fazer almoço para a família', 'CONCLUIDA', 5, 5),
                                                                                 ('Organizar armário', 'Separar roupas para doação', 'PENDENTE', 6, 6);
