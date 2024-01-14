-- criando tabela
create table cursos(
	id serial primary key,
	nome varchar (200) unique not null,
	preco integer not null,
	criado_em timestamp not null
)

-- inserindo dados
insert into cursos(nome, preco, criado_em)
values ('descomplicando java e spring', 799, current_timestamp);

-- listagem de dados
select * from cursos where criado_em >= timestamp '2024-01-12 10:20:13.423'

-- atualizando
update cursos set nome = 'giropops', preco = 0 where id = 1

-- excluindo
delete from cursos where nome = 'giropops'