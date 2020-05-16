package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.DeviceDto;
import ua.lviv.iot.lab6.mapper.impl.DeviceMapper;
import ua.lviv.iot.lab6.model.Device;
import ua.lviv.iot.lab6.repository.DeviceRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    final DeviceRepo deviceRepo;
    final DeviceMapper deviceMapper;

    public DeviceController(DeviceRepo deviceRepo, DeviceMapper deviceMapper) {
        this.deviceRepo = deviceRepo;
        this.deviceMapper = deviceMapper;
    }

    @GetMapping("/{id}")
    public DeviceDto getById(@PathVariable int id) {
        return deviceMapper.convertToDto(deviceRepo.getOne(id));
    }

    @GetMapping("/")
    public List<DeviceDto> getAll() {
        List<Device> devices = deviceRepo.findAll();
        List<DeviceDto> deviceDtos = new LinkedList<>();
        for (Device device: devices) {
            deviceDtos.add(deviceMapper.convertToDto(device));
        }
        return deviceDtos;
    }

    @PostMapping("/")
    public DeviceDto create(@RequestBody DeviceDto deviceDto) {
        return deviceMapper.convertToDto(deviceRepo.save(deviceMapper.convertToModel(deviceDto)));
    }

    @PutMapping("/")
    public DeviceDto update(@RequestBody DeviceDto deviceDto) {
        return deviceMapper.convertToDto(deviceRepo.save(deviceMapper.convertToModel(deviceDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        deviceRepo.deleteById(id);
    }

}
