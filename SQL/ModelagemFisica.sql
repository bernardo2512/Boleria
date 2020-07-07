create table cliente(
    cdcliente serial,
    nomeSobrenome varchar(128) not null
);

create table telefone(
    cdtelefone serial,
    tipo_telefone varchar(3) not null,
    ddd varchar(2) not null,
    numero varchar(10) not null,
    cdcliente int not null
);

create table endereco(
    cdendereco serial,
    rua varchar(255) not null,
    numero varchar(8) not null,
    cep varchar(9) not null,
    bairro varchar(32) not null,
    cdcliente int not null
);

create table agenda(
    cdagenda serial,
    data_entrega date not null,
    data_pagamento date not null default '01/01/0001' ,
    pendente boolean not null,
    cdcliente int not null
);

create table produto(
    cdproduto serial,
    descr varchar(255) not null,
    preco float not null
);

create table pedido(
    cdpedido serial,
    cdproduto int not null,
    quantidade int not null,
    valor_venda float not null,
    cdagenda int not null
);

alter table cliente add primary key(cdcliente);
alter table telefone add primary key(cdtelefone);
alter table endereco add primary key(cdendereco);
alter table agenda add primary key(cdagenda);
alter table produto add primary key(cdproduto);
alter table pedido add primary key(cdpedido);

alter table telefone 
add constraint fk_telefone_cliente foreign key(cdcliente)
references cliente(cdcliente)
on update cascade
on delete no action;

alter table endereco 
add constraint fk_endereco_cliente foreign key(cdcliente)
references cliente(cdcliente)
on update cascade
on delete no action;

alter table agenda 
add constraint fk_agenda_cliente foreign key(cdcliente)
references cliente(cdcliente)
on update cascade
on delete no action;

alter table pedido 
add constraint fk_pedido_produto foreign key(cdproduto)
references produto(cdproduto)
on update cascade
on delete no action;

alter table pedido 
add constraint fk_pedido_agenda foreign key(cdagenda)
references agenda(cdagenda)
on update cascade
on delete no action;

insert into cliente(nomeSobrenome) values ('Bernardo Luz'),('Carlos Luz'),('Jose Vanderlinde'),('Luiz Vanderlinde');
insert into endereco(rua,numero,cep,bairro,cdcliente) values ('Rua dos bobos','0','88101400','campinas',1),
('Rua perto do HU','125','66666666','trindade',2),('Rua de santo amaro','669','33336666','sul do rio',3),
('Rua de santo amaro 22','667','3333688','sul do rio',4);
insert into telefone(tipo_telefone,ddd,numero,cdcliente) values ('PES','48','991412512',1),('PES','48','996372999',2),
('COM','48','999639963',3),('RES','48','88887745',4);
insert into produto(descr,preco) values ('Bolo pacoca com pacoca vulcao',20.00),('Bolo pacoca com pacoca normal',18.00),
('Bolo laranja normal',12.00),('Bolo cenoura normal',15.00),('Bolo cenoura vulcao',18),
('Bolo milho com fuba',15),('brownie confeti 100g',4);
insert into agenda(data_entrega,pendente,cdcliente) values ('19/06/2020',true,1),('20/06/2020',true,2),
('19/06/2020',true,3),('20/06/2020',true,4);
insert into pedido(cdproduto,quantidade,valor_venda,cdagenda) values (1,2,40.00,1),(7,2,8.00,1),(2,2,36.00,2),(1,2,40.00,3),
(1,2,40.00,4);

select * from cliente;
select * from produto;
select * from agenda;
select * from pedido;

select c.nomesobrenome,pr.descr,a.data_entrega,a.data_pagamento from cliente c
inner join agenda a on c.cdcliente = a.cdcliente
inner join pedido p on p.cdagenda = a.cdagenda
inner join produto pr on pr.cdproduto = p.cdproduto
where pendente = true
order by data_entrega;

update agenda set data_pagamento = '19/06/2020' where cdagenda = 1;
update agenda set pendente = false where cdagenda = 1;

