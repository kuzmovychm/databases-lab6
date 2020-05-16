package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.lab6.model.Employee;
import ua.lviv.iot.lab6.model.Manufacturer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {

    private Integer id;
    private String title;
    private Integer price;
    private String currency;
    private Boolean inRepair;
    private String model;
    private Integer deviceManufacturerId;

}
