show databases;
create database projeto_inter;
use projeto_inter;
show tables;

-- drop database projeto_inter;
-- drop table ranking;
-- drop table user;
-- drop table perguntas;

create table user(username varchar(30) primary key unique, password char(20) not null, ra integer not null);
-- select * from user;

create table ranking(username varchar(30), constraint username foreign key (username) references user (username), pontos int);
-- select * from ranking;

create table perguntas(Pergunta varchar(200) not null unique, OpA varchar(50) not null,OpB varchar(50) not null,OpC varchar(50) not null,OpD varchar(50) not null, opCorreta integer not null, ordem int primary key auto_increment);
-- select * from perguntas;

insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Strings são utilizadas em Python para:','Registrar informações de texto.','Registrar números.','Registrar números inteiros.','Registrar', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual é a principal função do comando input?',' Selecionar dados.','Entrada de dados.','Excluir dados.','Selecionar Classes.', 2);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Para que serve o comando print?','Saída de dados.','Copiar dados.','Compilar dados.','Excluir dados.', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('O que o sinal (=) representa em python?','Operador de atribuição.','Operador de igualdade.','Operador de conclusão.','Operador de probabilidade.', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Para qual finalidade o comando \\n é utilizado?','Número de casas decimais.','Selecionar um comando.','Utilizar a classe selecionada.','Nova linha', 4);

insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('O método .format é aplicado diretamente a:','Um número formatado.','Uma string.','Um número inteiro.','Uma lista.', 2);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual é a função que %d exerce em python?','Converte números para inteiros.','Divide os números selecionados por d.','Converte Strings em números.','Converte números para Strings.', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual o comando para criar uma lista?','lista = []','lista.append','lista.pop','create list {}', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('A função Randint (0,10) gera:','0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.','0, 1, 2, 3, 4, 5, 6, 7, 8, 9.','1, 2, 3, 4, 5, 6, 7, 8, 9, 10.','1, 2, 3, 4, 5, 6, 7, 8, 9.', 4);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value (' Qual é a resposta apresentada pelo sistema:\nfor x in range(5)\n	print(x)','Exibe os números de 0 a 4.','Exibe o número 5.','Exibe o número 4.','Exibe os números de 0 a 5.', 1);

insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Como se modifica uma String?','Utilizando comandos como .format.','Strings são imutáveis.','Convertendo para números inteiros.','Trocando a classe da String.', 2);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual desses é uma estrutura de repetição?','for','if','else','elif ', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Como criar uma lista com números de 1 a 5?','lista = [1, 2, 3, 4, 5]','lista = num(1, 5)','lista = {1, 2, 3, 4, 5}','lista = (1, 2, 3, 4, 5)', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual operador lógico utilizado para\nverificar se dois valores são diferentes?','!=','==','≠','>=', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual método pode ser utilizado para \nretornar o número de itens em uma lista?','len()','append()','count()','pop()', 1);

insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual método para trabalhar com Strings\n deixa todos os caracteres maiúsculos?','upper()','swap()','uppercase()','swapcase()', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Como você insere comentários em um código Python?','/*Isso é um comentário*/',' /Isso é um comentário/','#Isso é um comentário','@Isso é um comentário@', 3);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual instrução é usada para parar um loop?','return','exit','stop','break ', 4);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual a forma correta de declarar uma função?','def soma(A, B)','function soma(A, B):','soma(A, B){ }','import function(A,B):', 1);
insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Qual dessas coleções define uma tupla?','Tupla = ["Ana", "Roberto", "Luisa"]','Tupla = {"Ana": "Roberto", "Luisa"}','Tupla = ("Ana", "Roberto", "Luisa")','Tupla: {"Ana", "Roberto", "Luisa"}', 3);

insert into perguntas(Pergunta,OpA,OpB,OpC,OpD,opCorreta) value ('Fim','Fim','Fim','Fim','Fim', 3);

-- SELECT COUNT(*) FROM perguntas;

SET SQL_SAFE_UPDATES = 0;

