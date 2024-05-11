create table user
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(10)                  not null comment '用户名',
    password    varchar(10) default '123456' not null comment '用户密码',
    name        varchar(10)                  not null comment '用户姓名',
    kind        tinyint unsigned             not null comment '用户类型，说明：1 为经理(全部功能)，2 为店员/采购人员(销售单那个页面)，3为仓库管理员(库存管理页面)',
    gender      tinyint unsigned             not null comment '性别，说明：1 男，2 女',
    create_time datetime                     not null comment '创建时间'
)
    comment '用户表';

INSERT INTO user (id, username, password, name, kind, gender, create_time) VALUES (1, 'lisi', '123456', '李四', 1, 1, '2024-05-10 18:51:05');
