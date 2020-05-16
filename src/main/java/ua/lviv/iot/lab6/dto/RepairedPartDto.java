package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.lab6.model.Manufacturer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepairedPartDto {

    private Integer id;
    private Integer price;
    private Integer repairPrice;
    private String currency;
    private Integer partManufacturerId;

}
