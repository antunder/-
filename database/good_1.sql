create table good
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    name        varchar(20)            not null comment '货品名称',
    state       tinyint unsigned       not null comment '货品状态, 说明: 1 上架, 2 未上架',
    decri       varchar(10)            not null comment '货品规格，如：200ml，50g',
    store_id    tinyint unsigned       null comment '仓库id',
    jh_pri      double(10, 2) unsigned not null comment '进货价',
    pf_pri      double(10, 2) unsigned not null comment '批发价',
    ls_pri      double(10, 2) unsigned not null comment '零售价',
    create_time datetime               not null comment '创建时间',
    storage     int unsigned           not null comment '货品库存'
)
    comment '货品表';

INSERT INTO db02.good (id, name, state, decri, store_id, jh_pri, pf_pri, ls_pri, create_time, storage) VALUES (1, '可乐', 2, '150mL', 1, 2, 2.3, 3, '2024-05-10 16:12:31', 100);
INSERT INTO db02.good (id, name, state, decri, store_id, jh_pri, pf_pri, ls_pri, create_time, storage) VALUES (2, '可乐', 1, '1L', 1, 6, 6.4, 7, '2024-05-10 16:13:10', 100);
INSERT INTO db02.good (id, name, state, decri, store_id, jh_pri, pf_pri, ls_pri, create_time, storage) VALUES (3, '阿萨姆', 2, '200mL', 2, 3, 3.2, 4, '2024-05-10 16:13:43', 100);
INSERT INTO db02.good (id, name, state, decri, store_id, jh_pri, pf_pri, ls_pri, create_time, storage) VALUES (4, '康师傅红烧牛肉面', 1, '200g', 1, 2, 2.5, 3, '2024-05-10 16:14:22', 100);
INSERT INTO db02.good (id, name, state, decri, store_id, jh_pri, pf_pri, ls_pri, create_time, storage) VALUES (7, '雪碧', 2, '150mL', 1, 2, 2.3, 3, '2024-05-11 11:17:46', 100);
