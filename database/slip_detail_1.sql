create table slip_detail
(
    id      int unsigned auto_increment comment 'ID'
        primary key,
    slip_id tinyint unsigned not null comment '开单id',
    good_id tinyint unsigned not null comment '货品id',
    number  int unsigned     not null comment '数量细节',
    notes   varchar(20)      null comment '备注'
)
    comment '开单细节表';

INSERT INTO db02.slip_detail (id, slip_id, good_id, number, notes) VALUES (1, 1, 1, 2, null);
INSERT INTO db02.slip_detail (id, slip_id, good_id, number, notes) VALUES (2, 1, 2, 3, null);
INSERT INTO db02.slip_detail (id, slip_id, good_id, number, notes) VALUES (4, 3, 2, 2, null);
INSERT INTO db02.slip_detail (id, slip_id, good_id, number, notes) VALUES (5, 3, 1, 3, null);
