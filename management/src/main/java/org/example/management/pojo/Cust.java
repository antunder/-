package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cust {
    private Integer id;
    private String name;
    private String address;
    private Short kind;
    private Short gender;
    private LocalDateTime createTime;
}
