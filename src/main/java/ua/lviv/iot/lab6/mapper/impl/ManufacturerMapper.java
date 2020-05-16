package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.ManufacturerDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.Manufacturer;
import ua.lviv.iot.lab6.repository.ManufacturerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturerMapper implements GeneralMapper<Manufacturer, ManufacturerDto> {

    final ManufacturerRepo manufacturerRepo;

    public ManufacturerMapper(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public ManufacturerDto convertToDto(Manufacturer model) {
        return ManufacturerDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .originCountry(model.getOriginCountry())
                .email(model.getEmail())
                .websiteLink(model.getWebsiteLink())
                .build();
    }

    @Override
    public Manufacturer convertToModel(ManufacturerDto dto) {
        return Manufacturer.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .originCountry(dto.getOriginCountry())
                .email(dto.getEmail())
                .websiteLink(dto.getWebsiteLink())
                .build();
    }
}
