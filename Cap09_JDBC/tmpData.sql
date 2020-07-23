--
-- Java - Guia do Programador - 3a Ed.
-- Autor: Peter Jandl Junior
-- (c) 2015, Novatec Editora Ltda.
-- 
-- Exemplo 9.24
--
-- Remove tabela (que deve existir)
DROP TABLE TMP;
-- Cria tabela
CREATE TABLE TMP (
	chave int not null primary key,
	valor varchar(50)
);
-- Inclusao de registros
insert into TMP VALUES (1, 'Peter');
insert into TMP VALUES (2, 'Jandl');
insert into TMP VALUES (3, 'Jr');
-- Lista registros
SELECT * FROM TMP;
-- Lista registros
SELECT * FROM PLANETAS;
