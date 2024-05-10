package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private Integer id;
    private String name;
    private Short kind;
    private LocalDateTime createTime;
}
