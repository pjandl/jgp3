DROP TABLE TMP
CREATE TABLE TMP (CHAVE VARCHAR(20) NOT NULL UNIQUE, VALOR VARCHAR(50))
INSERT INTO TMP VALUES ('DB', 'Apache Derby')
INSERT INTO TMP VALUES ('vers�o', '10.10')
INSERT INTO TMP VALUES ('URL', 'jdbc:derby://localhost:1527/ssolar')
INSERT INTO TMP VALUES ('user', 'app')
