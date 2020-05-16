package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.RepairInfoDto;
import ua.lviv.iot.lab6.mapper.impl.RepairInfoMapper;
import ua.lviv.iot.lab6.model.RepairInfo;
import ua.lviv.iot.lab6.repository.RepairInfoRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/repair-infos")
public class RepairInfoController {

    final RepairInfoRepo repairInfoRepo;
    final RepairInfoMapper repairInfoMapper;

    public RepairInfoController(RepairInfoRepo repairInfoRepo, RepairInfoMapper repairInfoMapper) {
        this.repairInfoRepo = repairInfoRepo;
        this.repairInfoMapper = repairInfoMapper;
    }

    @GetMapping("/{id}")
    public RepairInfoDto getById(@PathVariable int id) {
        return repairInfoMapper.convertToDto(repairInfoRepo.getOne(id));
    }

    @GetMapping("/")
    public List<RepairInfoDto> findAll() {
        List<RepairInfo> repairInfos = repairInfoRepo.findAll();
        List<RepairInfoDto> repairInfoDtos = new LinkedList<>();
        for (RepairInfo repairInfo: repairInfos) {
            repairInfoDtos.add(repairInfoMapper.convertToDto(repairInfo));
        }
        return repairInfoDtos;
    }

    @PostMapping("/")
    public RepairInfoDto create(@RequestBody RepairInfoDto repairInfoDto) {
        return repairInfoMapper.convertToDto(repairInfoRepo.save(repairInfoMapper.convertToModel(repairInfoDto)));
    }

    @PutMapping("/")
    public RepairInfoDto update(@RequestBody RepairInfoDto repairInfoDto) {
        return repairInfoMapper.convertToDto(repairInfoRepo.save(repairInfoMapper.convertToModel(repairInfoDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repairInfoRepo.deleteById(id);
    }

}
