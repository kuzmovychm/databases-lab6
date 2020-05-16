package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.ManufacturerDto;
import ua.lviv.iot.lab6.mapper.impl.ManufacturerMapper;
import ua.lviv.iot.lab6.model.Manufacturer;
import ua.lviv.iot.lab6.repository.ManufacturerRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    final ManufacturerRepo manufacturerRepo;
    final ManufacturerMapper manufacturerMapper;

    public ManufacturerController(ManufacturerRepo manufacturerRepo, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepo = manufacturerRepo;
        this.manufacturerMapper = manufacturerMapper;
    }

    @GetMapping("/{id}")
    public ManufacturerDto getById(@PathVariable int id) {
        return manufacturerMapper.convertToDto(manufacturerRepo.getOne(id));
    }

    @GetMapping("/")
    public List<ManufacturerDto> findAll() {
        List<Manufacturer> manufacturers = manufacturerRepo.findAll();
        List<ManufacturerDto> manufacturerDtos = new LinkedList<>();
        for (Manufacturer manufacturer: manufacturers) {
            manufacturerDtos.add(manufacturerMapper.convertToDto(manufacturer));
        }
        return manufacturerDtos;
    }

    @PostMapping("/")
    public ManufacturerDto create(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerMapper.convertToDto(manufacturerRepo.save(manufacturerMapper.convertToModel(manufacturerDto)));
    }

    @PutMapping("/")
    public ManufacturerDto update(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerMapper.convertToDto(manufacturerRepo.save(manufacturerMapper.convertToModel(manufacturerDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        manufacturerRepo.deleteById(id);
    }

}
