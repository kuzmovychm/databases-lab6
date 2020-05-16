package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.RepairServiceDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.RepairService;
import ua.lviv.iot.lab6.repository.EmployeeRepo;

@Component
public class RepairServiceMapper implements GeneralMapper<RepairService, RepairServiceDto> {

    final EmployeeRepo employeeRepo;

    public RepairServiceMapper(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public RepairServiceDto convertToDto(RepairService model) {
        return RepairServiceDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .phoneNumber(model.getPhoneNumber())
                .address(model.getAddress())
                .openingHour(model.getOpeningHour())
                .closingHour(model.getClosingHour())
                .rating(model.getRating())
                .directorId(model.getDirector().getId())
                .build();
    }

    @Override
    public RepairService convertToModel(RepairServiceDto dto) {
        return RepairService.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .openingHour(dto.getOpeningHour())
                .closingHour(dto.getClosingHour())
                .rating(dto.getRating())
                .director(employeeRepo.getOne(dto.getDirectorId()))
                .build();
    }
}
