package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlipDetail {
    private Integer id;
    private Integer slipId;
    private Integer goodId;
    private Integer number;
    private String notes;
}
