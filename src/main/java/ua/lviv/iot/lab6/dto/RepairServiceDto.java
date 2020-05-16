package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.lab6.model.Employee;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepairServiceDto {

    private Integer id;
    private String title;
    private String openingHour;
    private String closingHour;
    private String address;
    private String phoneNumber;
    private String rating;
    private Integer directorId;

}
