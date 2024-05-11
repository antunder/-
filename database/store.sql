create table store
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    name        varchar(20)      not null comment '仓库名称',
    kind        tinyint unsigned not null comment '仓库类型，说明：1 为大库，2 为门店',
    create_time datetime         not null comment '创建时间',
    constraint name
        unique (name)
)
    comment '仓库表';

INSERT INTO store (id, name, kind, create_time) VALUES (1, '哈威店', 2, '2024-05-08 21:00:57');
INSERT INTO store (id, name, kind, create_time) VALUES (2, '山威店', 2, '2024-05-08 21:01:18');
INSERT INTO store (id, name, kind, create_time) VALUES (3, '哈威仓', 1, '2024-05-09 21:01:32');
INSERT INTO store (id, name, kind, create_time) VALUES (4, '山威仓', 1, '2024-05-08 21:01:49');
INSERT INTO store (id, name, kind, create_time) VALUES (5, '高区仓', 1, '2024-05-08 21:02:03');
INSERT INTO store (id, name, kind, create_time) VALUES (6, '环翠仓', 1, '2024-05-08 21:02:14');
INSERT INTO store (id, name, kind, create_time) VALUES (7, '山东店', 2, '2024-05-10 15:31:25');
