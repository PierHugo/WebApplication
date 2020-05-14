create table admin
(
    id         bigint       not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    username   varchar(255) not null,
    password   varchar(255) not null,
    age        varchar(255) not null,
    city       varchar(255) not null,
    constraint usernameunique unique (username)
) engine = InnoDB;

INSERT INTO admin
VALUES (0, 'admin', 'admin', 'admin', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 20, 'Paris');

create table user
(
    id         bigint       not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    username   varchar(255) not null,
    password   varchar(255) not null,
    age        varchar(255) not null,
    city       varchar(255) not null,
    constraint usernameunique unique (username)
) engine = InnoDB;

INSERT INTO user
VALUES (0, 'user', 'user', 'user', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 18, 'Bordeaux');
-- password : password
