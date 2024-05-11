package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slip {
    private  Integer id;
    private Short kind;
    private Short state;
    private Integer storeId;
    private Integer custId;
    private LocalDate createTime;
}
