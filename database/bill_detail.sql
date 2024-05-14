create table bill_detail
(
    id       int unsigned auto_increment comment 'ID'
        primary key,
    slip_id  tinyint unsigned       not null comment '开单id',
    name     varchar(20)            not null comment '货品名称',
    decri    varchar(10)            not null comment '货品规格，如：200ml，50g',
    store_id tinyint unsigned       null comment '仓库id',
    jh_pri   double(10, 2) unsigned not null comment '进货价',
    number   int unsigned           not null comment '数量细节',
    notes    varchar(20)            null comment '备注'
)
    comment '采购单细节表';

INSERT INTO db02.bill_detail (id, slip_id, name, decri, store_id, jh_pri, number, notes) VALUES (4, 7, '可乐', '150mL', 1, 1.5, 100, null);
