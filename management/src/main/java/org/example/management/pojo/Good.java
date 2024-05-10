package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Integer id;
    private String name;
    private Integer state;
    private String decri;
    private Integer storeId;
    private Double jhPri;//进货价
    private Double pfPri;//批发价
    private Double lsPri;//零售价
    private Integer storage;
    private LocalDateTime createTime;
}
