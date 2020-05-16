package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.lab6.model.Employee;
import ua.lviv.iot.lab6.model.RepairService;
import ua.lviv.iot.lab6.model.RepairedPart;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepairInfoDto {

    private Integer id;
    private String repairStatus;
    private String repairType;
    private String startingDate;
    private String endingDate;

}
