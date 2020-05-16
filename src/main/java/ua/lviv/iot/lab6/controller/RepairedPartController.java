package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.RepairedPartDto;
import ua.lviv.iot.lab6.mapper.impl.RepairedPartMapper;
import ua.lviv.iot.lab6.model.RepairedPart;
import ua.lviv.iot.lab6.repository.RepairedPartRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/repaired-parts")
public class RepairedPartController {

    final RepairedPartRepo repairedPartRepo;
    final RepairedPartMapper repairedPartMapper;

    public RepairedPartController(RepairedPartRepo repairedPartRepo, RepairedPartMapper repairedPartMapper) {
        this.repairedPartRepo = repairedPartRepo;
        this.repairedPartMapper = repairedPartMapper;
    }

    @GetMapping("/{id}")
    public RepairedPartDto getById(@PathVariable int id) {
        return repairedPartMapper.convertToDto(repairedPartRepo.getOne(id));
    }

    @GetMapping("/")
    public List<RepairedPartDto> findAll() {
        List<RepairedPart> repairedParts = repairedPartRepo.findAll();
        List<RepairedPartDto> repairedPartDtos = new LinkedList<>();
        for (RepairedPart repairedPart: repairedParts) {
            repairedPartDtos.add(repairedPartMapper.convertToDto(repairedPart));
        }
        return repairedPartDtos;
    }

    @PostMapping("/")
    public RepairedPartDto create(@RequestBody RepairedPartDto repairedPartDto) {
        return repairedPartMapper.convertToDto(repairedPartRepo
                .save(repairedPartMapper.convertToModel(repairedPartDto)));
    }

    @PutMapping("/")
    public RepairedPartDto update(@RequestBody RepairedPartDto repairedPartDto) {
        return repairedPartMapper.convertToDto(repairedPartRepo
                .save(repairedPartMapper.convertToModel(repairedPartDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repairedPartRepo.deleteById(id);
    }

}
