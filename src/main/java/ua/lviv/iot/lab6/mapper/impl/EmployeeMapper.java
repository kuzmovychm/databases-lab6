package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.EmployeeDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.Employee;
import ua.lviv.iot.lab6.repository.RepairServiceRepo;

@Component
public class EmployeeMapper implements GeneralMapper<Employee, EmployeeDto> {

    final RepairServiceRepo repairServiceRepo;

    public EmployeeMapper(RepairServiceRepo repairServiceRepo) {
        this.repairServiceRepo = repairServiceRepo;
    }

    @Override
    public EmployeeDto convertToDto(Employee model) {
        return EmployeeDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .secondName(model.getSecondName())
                .salary(model.getSalary())
                .currency(model.getCurrency())
                .workingDayStart(model.getWorkingDayStart())
                .workingDayEnd(model.getWorkingDayEnd())
                .workingPlaceId(model.getWorkingPlace().getId())
                .build();
    }

    @Override
    public Employee convertToModel(EmployeeDto dto) {
        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .salary(dto.getSalary())
                .currency(dto.getCurrency())
                .workingDayStart(dto.getWorkingDayStart())
                .workingDayEnd(dto.getWorkingDayEnd())
                .workingPlace(repairServiceRepo.getOne(dto.getWorkingPlaceId()))
                .build();
    }
}
