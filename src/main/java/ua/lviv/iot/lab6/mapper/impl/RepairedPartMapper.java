package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.RepairedPartDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.RepairedPart;
import ua.lviv.iot.lab6.repository.ManufacturerRepo;

@Component
public class RepairedPartMapper implements GeneralMapper<RepairedPart, RepairedPartDto> {

    final ManufacturerRepo manufacturerRepo;

    public RepairedPartMapper(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public RepairedPartDto convertToDto(RepairedPart model) {
        return RepairedPartDto.builder()
                .id(model.getId())
                .price(model.getPrice())
                .repairPrice(model.getRepairPrice())
                .currency(model.getCurrency())
                .partManufacturerId(model.getPartManufacturer().getId())
                .build();
    }

    @Override
    public RepairedPart convertToModel(RepairedPartDto dto) {
        return RepairedPart.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .repairPrice(dto.getRepairPrice())
                .currency(dto.getCurrency())
                .partManufacturer(manufacturerRepo.getOne(dto.getPartManufacturerId()))
                .build();
    }
}
