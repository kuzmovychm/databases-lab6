package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.RepairServiceDto;
import ua.lviv.iot.lab6.mapper.impl.RepairServiceMapper;
import ua.lviv.iot.lab6.model.RepairService;
import ua.lviv.iot.lab6.repository.RepairServiceRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/repair-services")
public class RepairServiceController {

    final RepairServiceRepo repairServiceRepo;
    final RepairServiceMapper repairServiceMapper;

    public RepairServiceController(RepairServiceRepo repairServiceRepo, RepairServiceMapper repairServiceMapper) {
        this.repairServiceRepo = repairServiceRepo;
        this.repairServiceMapper = repairServiceMapper;
    }

    @GetMapping("/{id}")
    public RepairServiceDto getById(@PathVariable int id) {
        return repairServiceMapper.convertToDto(repairServiceRepo.getOne(id));
    }

    @GetMapping("/")
    public List<RepairServiceDto> findAll() {
        List<RepairService> repairServices = repairServiceRepo.findAll();
        List<RepairServiceDto> repairServiceDtos = new LinkedList<>();
        for (RepairService repairService: repairServices) {
            repairServiceDtos.add(repairServiceMapper.convertToDto(repairService));
        }
        return repairServiceDtos;
    }

    @PostMapping("/")
    public RepairServiceDto create(@RequestBody RepairServiceDto repairServiceDto) {
        return repairServiceMapper.convertToDto(repairServiceRepo
                .save(repairServiceMapper.convertToModel(repairServiceDto)));
    }

    @PutMapping("/")
    public RepairServiceDto update(@RequestBody RepairServiceDto repairServiceDto) {
        return repairServiceMapper.convertToDto(repairServiceRepo
                .save(repairServiceMapper.convertToModel(repairServiceDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repairServiceRepo.deleteById(id);
    }

}
