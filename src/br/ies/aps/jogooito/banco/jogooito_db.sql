CREATE DATABASE IF NOT EXISTS jogo_oito;

CREATE TABLE jogador (
	id SERIAL PRIMARY KEY,
	nome varchar(50),
	jogadas integer,
	ganhador boolean,
	id_tabuleiro integer
);

CREATE TABLE TABULEIRO (
	id SERIAL PRIMARY KEY,
	campo_cima_esquerda integer,
	campo_cima_meio integer,
	campo_cima_direita integer,
	campo_meio_esquerda integer,
	campo_meio_meio integer,
	campo_meio_direita integer,
	campo_baixo_esquerda integer,
	campo_baixo_meio integer,
	campo_baixo_direita integer
);

ALTER TABLE jogador
	ADD CONSTRAINT id_tabuleiro_fk 
	FOREIGN KEY (id_tabuleiro)
	REFERENCES tabuleiro (id)
	ON UPDATE CASCADE
	ON DELETE NO ACTION;
