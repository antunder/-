create table slip_detail
(
    id      int unsigned auto_increment comment 'ID'
        primary key,
    slip_id tinyint unsigned not null comment '开单id',
    good_id tinyint unsigned not null comment '货品id',
    number  int unsigned     not null comment '数量细节'
)
    comment '开单细节表';

INSERT INTO slip_detail (id, slip_id, good_id, number) VALUES (1, 1, 1, 2);
INSERT INTO slip_detail (id, slip_id, good_id, number) VALUES (2, 1, 2, 3);
