-- DROP TABLES en orden de dependencia (hijos antes que padres)
DROP TABLE IF EXISTS tb_pedido_detalle;
DROP TABLE IF EXISTS tb_pago;
DROP TABLE IF EXISTS tb_comprobante;
DROP TABLE IF EXISTS tb_producto;
DROP TABLE IF EXISTS tb_provider;
DROP TABLE IF EXISTS tb_pedido;
DROP TABLE IF EXISTS seg_usuario;
DROP TABLE IF EXISTS tb_persona;
DROP TABLE IF EXISTS tb_catalogo_valor;
DROP TABLE IF EXISTS tb_catalogo;
DROP TABLE IF EXISTS seg_acceso;
DROP TABLE IF EXISTS seg_rol;
DROP TABLE IF EXISTS seg_perfil;

create table seg_perfil
(
    id     bigint auto_increment
        primary key,
    nombre varchar(255) null
);

create table seg_rol
(
    id          bigint auto_increment
        primary key,
    css         varchar(255) null,
    descripcion varchar(255) null,
    icono       varchar(255) null,
    nombre      varchar(255) null,
    ruta        varchar(255) null
);

create table seg_acceso
(
    id        bigint auto_increment
        primary key,
    perfil_id bigint not null,
    rol_id    bigint not null,
    constraint FKcnmr5fad558jr7b2gug2v34rl
        foreign key (rol_id) references seg_rol (id),
    constraint FKtgv6rbky8xhmsgvi5qil93g5m
        foreign key (perfil_id) references seg_perfil (id)
);

create table tb_catalogo
(
    id          int auto_increment
        primary key,
    codigo      varchar(255) null,
    descripcion varchar(255) null
);

create table tb_catalogo_valor
(
    id          int auto_increment
        primary key,
    codigo      varchar(255) null,
    descripcion varchar(255) null,
    valor       varchar(255) null,
    id_catalogo int          null,
    constraint FKjdpsbfdbtdqourhctf1u5drg2
        foreign key (id_catalogo) references tb_catalogo (id)
);

create table tb_persona
(
    idPersona           int auto_increment
        primary key,
    apellidos           varchar(255) null,
    direccion           varchar(255) null,
    fechaNacimiento     date         null,
    genero              varchar(255) null,
    nombres_razonsocial varchar(255) null,
    numeroDocumento     varchar(255) null,
    telefono            varchar(255) null,
    tipo_doc            int          null,
    constraint FKqdpv69axybq5cc2gxnf9t9ie8
        foreign key (tipo_doc) references tb_catalogo_valor (id)
);

create table seg_usuario
(
    id         bigint auto_increment
        primary key,
    correo     varchar(255) null,
    password   varchar(255) null,
    username   varchar(255) null,
    perfil_id  bigint       null,
    persona_id int          null,
    constraint FK3md5j48gcj7hidkfpscxm8du3 foreign key (perfil_id) references seg_perfil (id),
    constraint FKgjepql24tvs8s2mo8a8gaudyh foreign key (persona_id) references tb_persona (idPersona)
);

create table tb_pedido
(
    id       int auto_increment
        primary key,
    canal    varchar(255) null,
    fecha    date         null,
    cod_usua bigint       null,
    cod_cliente int       null,
    constraint FKjxfuvjolpf18y18pg8agq08dh foreign key (cod_usua) references seg_usuario (id),
    constraint FKjxfuvjolpf18y18pg8agq08dhperson foreign key (cod_cliente) references tb_persona (idPersona)
);

create table tb_comprobante
(
    id           bigint auto_increment
        primary key,
    fechaEmision datetime(6)  null,
    numero       varchar(255) null,
    serie        varchar(255) null,
    info_emisor int          null,
    pedido_id    int          null,
    tipo         int          null,
    constraint UKik493a9ihvm6heafgtat0liun
        unique (pedido_id),
    constraint FKa5xgrauvkotu7gjkv67s05ls1
        foreign key (tipo) references tb_catalogo_valor (id),
    constraint FKppjontoge1julrs6ljrj257f0
        foreign key (info_emisor) references tb_catalogo (id),
    constraint FKr2jdd1k4g3vi0n9qswc4uxjpd
        foreign key (pedido_id) references tb_pedido (id)
);

create table tb_pago
(
    id         bigint auto_increment
        primary key,
    fechapago  datetime(6)  null,
    monto      double       not null,
    referencia varchar(255) null,
    estado     int          null,
    metodo     int          null,
    pedido_id  int          not null,
    constraint FKeom5l2mbnvg77dfto42de7mc9
        foreign key (estado) references tb_catalogo_valor (id),
    constraint FKhpedfva34gbam1173h41y4thh
        foreign key (metodo) references tb_catalogo_valor (id),
    constraint FKqe5s8lsxx6f9j6ap0ksijeijo
        foreign key (pedido_id) references tb_pedido (id)
);

create table tb_provider
(
    id         int auto_increment
        primary key,
    email      varchar(255) null,
    telefono   varchar(255) null,
    id_persona int          not null,
    constraint UKcmbh6x7gv288hk7d4pny7pi74
        unique (id_persona),
    constraint FKamtpn94hsm9l2ej9sbbsoe1kw
        foreign key (id_persona) references tb_persona (idPersona)
);

create table tb_producto
(
    id           int auto_increment
        primary key,
    descripcion  varchar(255) null,
    estado       bit          null,
    precio       double       null,
    stock        int          null,
    categoria    int          null,
    id_proveedor int          null,
    constraint FKc32tghvh2ydi6s94x56tx6elx
        foreign key (id_proveedor) references tb_provider (id),
    constraint FKebv7nqephg1axmsa7jah56a9d
        foreign key (categoria) references tb_catalogo_valor (id)
);

create table tb_pedido_detalle
(
    id        int auto_increment
        primary key,
    cantidad  int    null,
    descuento double null,
    precio    double null,
    id_pedido int    null,
    id_prod   int    null,
    constraint FK1t45p5mu89h160lr4s4d470mm
        foreign key (id_pedido) references tb_pedido (id),
    constraint FKolec66ph0rxyeovor431uv3sx
        foreign key (id_prod) references tb_producto (id)
);

