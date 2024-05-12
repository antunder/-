create table cust
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    name        varchar(10)      not null comment '客户姓名',
    address     varchar(20)      not null comment '客户地址',
    kind        tinyint unsigned not null comment '客户类型，说明：1 为批发客户，2 为零售客户，3为供货商',
    gender      tinyint unsigned not null comment '性别，说明：1 男，2 女',
    phone       varchar(20)      not null comment '联系方式',
    create_time datetime         not null comment '创建时间'
)
    comment '客户表';

INSERT INTO db02.cust (id, name, address, kind, gender, phone, create_time) VALUES (1, '张三', '哈尔滨工业大学（威海）', 1, 1, '13677232540', '2024-05-08 21:28:50');
INSERT INTO db02.cust (id, name, address, kind, gender, phone, create_time) VALUES (3, '李四', '哈尔滨工业大学（威海）', 2, 2, '19861355565', '2024-05-11 09:13:54');
INSERT INTO db02.cust (id, name, address, kind, gender, phone, create_time) VALUES (5, '王五', '哈尔滨工业大学（威海）', 3, 1, '15677232540', '2024-05-12 15:37:06');
