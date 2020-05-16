package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.DeviceDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.Device;
import ua.lviv.iot.lab6.repository.ManufacturerRepo;

@Component
public class DeviceMapper implements GeneralMapper<Device, DeviceDto> {

    final ManufacturerRepo manufacturerRepo;

    public DeviceMapper(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public DeviceDto convertToDto(Device model) {
        return DeviceDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .price(model.getPrice())
                .currency(model.getCurrency())
                .model(model.getModel())
                .inRepair(model.getInRepair())
                .deviceManufacturerId(model.getDeviceManufacturer().getId())
                .build();
    }

    @Override
    public Device convertToModel(DeviceDto dto) {
        return Device.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .currency(dto.getCurrency())
                .model(dto.getModel())
                .inRepair(dto.getInRepair())
                .deviceManufacturer(manufacturerRepo.getOne(dto.getDeviceManufacturerId()))
                .build();
    }
}
