package org.example.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetail {
    Integer id;
    Integer slipId;
    String name;
    String decri;
    Integer storeId;
    Double jhPri;
    Integer number;
    String notes;
}
