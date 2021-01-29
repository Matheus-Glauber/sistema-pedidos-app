-- Inserindo dados da entidade Categoria --
INSERT INTO CATEGORIA (ID, NOME) VALUES (1, 'informática');
INSERT INTO CATEGORIA (ID, NOME) VALUES (2, 'Educação');
INSERT INTO CATEGORIA (ID, NOME) VALUES (3, 'Eletrônico');
INSERT INTO CATEGORIA (ID, NOME) VALUES (4, 'Jogos');

-- Inserindo dados da entidade Produto --
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (1, 'Computador', 2000.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (2, 'Impressora', 250.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (3, 'Mouse', 30.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (4, 'Livro Java', 130.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (5, 'GTA V', 115.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (6, 'Kindle', 330.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (7, 'Máquina de Lavar', 900.0);
INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (8, 'Arte da Guerra', 50.0);

 -- Inserindo os relacionamentos --
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (1, 1);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (2, 1);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (3, 1);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (4, 2);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (5, 4);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (6, 3);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (7, 3);
INSERT INTO PRODUTO_CATEGORIA (produto_id, categoria_id) VALUES (8, 2);

-- Inserindo Estados --
INSERT INTO ESTADO (ID, ESTADO) VALUES (1, 'PB');
INSERT INTO ESTADO (ID, ESTADO) VALUES (2, 'MG');

-- Inserindo Cidades --
INSERT INTO CIDADE (ID, CIDADE, ESTADO_ID) VALUES (1, 'Campina Grande', 1);
INSERT INTO CIDADE (ID, CIDADE, ESTADO_ID) VALUES (2, 'João Pessoa', 1);
INSERT INTO CIDADE (ID, CIDADE, ESTADO_ID) VALUES (3, 'Belo Horizonte', 2);
