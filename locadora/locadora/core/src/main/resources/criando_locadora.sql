---------------
--ATOR
---------------
CREATE TABLE ator(
ator_id serial PRIMARY KEY,
ator_nome character varying(100)
);

COMMENT ON COLUMN ator.ator_id IS 'Campo identificador do ator';
COMMENT ON COLUMN ator.ator_nome IS 'Nome do ator';


---------------
--FILME
---------------
CREATE TABLE filme(
film_id serial PRIMARY KEY,
film_titulo character varying(100),
film_sinopse character varying(2000),
film_genero smallint CONSTRAINT generos CHECK film_genero in (1,2,3,4,5,6,7,8,9,10),
film_lancamento integer
);

COMMENT ON COLUMN filme.film_id IS 'Campo identificador do filme';
COMMENT ON COLUMN filme.film_titulo IS 'Titulo do filme';
COMMENT ON COLUMN filme.film_sinopse IS 'Sinopse do filme';
COMMENT ON COLUMN filme.film_genero IS 'Genero do filme. 1-Acao, 2-Comedia, 3-Drama, 4-Documentario, 5-Policial, 6-Musical, 7-Romance, 8-Suspense, 9-Terror, 10-Ficcao';
COMMENT ON COLUMN filme.film_lancamento IS 'Ano de lancamento d filme';

---------------
--FILME_ATOR
---------------

CREATE TABLE filme_ator
(
  filme_id serial NOT NULL,
  ator_id serial NOT NULL,
  CONSTRAINT fk_ator FOREIGN KEY (ator_id)
      REFERENCES ator (ator_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_filme FOREIGN KEY (filme_id)
      REFERENCES filme (film_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)