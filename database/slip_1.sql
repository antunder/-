create table slip
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    kind        tinyint unsigned not null comment '开单类型,说明：1为销售单，2为采购入库单',
    state       tinyint unsigned not null comment '开单状态, 说明: 1 未提交 2已提交（未审核）3已审核（未付款）4未付款 5未通过',
    store_id    tinyint unsigned not null comment '仓库id',
    cust_id     int unsigned     not null comment '客户id',
    create_time date             not null comment '创建时间'
)
    comment '开单表';

INSERT INTO db02.slip (id, kind, state, store_id, cust_id, create_time) VALUES (1, 1, 2, 1, 1, '2024-05-10');
INSERT INTO db02.slip (id, kind, state, store_id, cust_id, create_time) VALUES (3, 1, 2, 1, 1, '2024-05-12');
INSERT INTO db02.slip (id, kind, state, store_id, cust_id, create_time) VALUES (4, 1, 2, 1, 1, '2024-05-12');
INSERT INTO db02.slip (id, kind, state, store_id, cust_id, create_time) VALUES (5, 1, 2, 1, 1, '2024-05-12');
