package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.RepairInfoDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.RepairInfo;
import ua.lviv.iot.lab6.repository.RepairInfoRepo;

@Component
public class RepairInfoMapper implements GeneralMapper<RepairInfo, RepairInfoDto> {

    final RepairInfoRepo repairInfoRepo;

    public RepairInfoMapper(RepairInfoRepo repairInfoRepo) {
        this.repairInfoRepo = repairInfoRepo;
    }

    @Override
    public RepairInfoDto convertToDto(RepairInfo model) {
        return RepairInfoDto.builder()
                .id(model.getId())
                .repairType(model.getRepairType())
                .repairStatus(model.getRepairStatus())
                .startingDate(model.getStartingDate())
                .endingDate(model.getEndingDate())
                .build();
    }

    @Override
    public RepairInfo convertToModel(RepairInfoDto dto) {
        return RepairInfo.builder()
                .id(dto.getId())
                .repairType(dto.getRepairType())
                .repairStatus(dto.getRepairStatus())
                .startingDate(dto.getStartingDate())
                .endingDate(dto.getEndingDate())
                .build();
    }
}
