///////////////////////studente/////////////////////////////

INSERT INTO public.studente_enty
(id, name, email)
VALUES(1, 'goku', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(2, 'titi', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(3, 'gorran', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(4, 'pan', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(5, 'kuririn', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(6, 'vegeta', 'nome@gamil.com');

INSERT INTO public.studente_enty
(id, name, email)
VALUES(7, 'buma', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(8, 'picolo', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(9, 'yantia', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(10, 'kamin samar', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(11, 'sayadin', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(12, 'androide', 'nome@gamil.com');

INSERT INTO public.studente_enty
(id, name, email)
VALUES(13, 'van dame', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(14, 'bruce lee', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(15, 'check norri', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(16, 'lioto', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(17, 'rickison', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(18, 'royce', 'nome@gamil.com');


INSERT INTO public.studente_enty
(id, name, email)
VALUES(19, 'arnod', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(20, 'rambo', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(21, 'rock bao boa', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(22, 'conan', 'nome@gamil.com');
INSERT INTO public.studente_enty
(id, name, email)
VALUES(23, 'marvel', 'nome@gamil.com');

INSERT INTO public.studente_enty
(id, name, email)
VALUES(24, 'homem de ferro', 'nome@gamil.com');

//////////ibge/////////////


INSERT INTO public.uf_ibge
(id, nome, sigla)
VALUES(33, 'Rio de Janeiro', 'RJ');

INSERT INTO public.regiao_ibge
(id, nome, sigla)
VALUES(3, 'Sudeste', 'SE');

INSERT INTO public.ibge
(id, nome, regiao_id, uf_id)
VALUES(3301, 'Noroeste Fluminense', 3, 33);

///////////////carteira////////////////////

select sum(c.valor) as total from tb_carteira c;

select * from  tb_carteira tc;

insert into tb_carteira (id, valor) values (1,50);
insert into tb_carteira (id, valor) values (2,250);
insert into tb_carteira (id, valor) values (3,350);
insert into tb_carteira (id, valor) values (4,450);
insert into tb_carteira (id, valor) values (5,550);
insert into tb_carteira (id, valor) values (6,650);
insert into tb_carteira (id, valor) values (7,750);



