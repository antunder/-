create table slip
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    kind        tinyint unsigned not null comment '开单类型,说明：1为销售单，2为采购入库单',
    state       tinyint unsigned not null comment '开单状态, 说明: 1 审核, 2 未审核,3未提交',
    store_id    tinyint unsigned not null comment '仓库id',
    cust_id     int unsigned     not null comment '客户id',
    create_time date             not null comment '创建时间'
)
    comment '开单表';

INSERT INTO slip (id, kind, state, store_id, cust_id, create_time) VALUES (1, 1, 2, 1, 1, '2024-05-10');
