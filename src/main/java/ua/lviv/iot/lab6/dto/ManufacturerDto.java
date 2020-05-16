package ua.lviv.iot.lab6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.lab6.model.Device;
import ua.lviv.iot.lab6.model.RepairedPart;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {

    private Integer id;
    private String title;
    private String originCountry;
    private String email;
    private String websiteLink;

}
