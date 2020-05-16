package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Integer id;
    private String firstName;
    private String secondName;
    private Integer salary;
    private String currency;
    private Integer workingDayStart;
    private Integer workingDayEnd;
    private Integer workingPlaceId;

}
