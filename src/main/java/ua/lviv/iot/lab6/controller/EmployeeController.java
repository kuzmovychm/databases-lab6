package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.EmployeeDto;
import ua.lviv.iot.lab6.mapper.impl.EmployeeMapper;
import ua.lviv.iot.lab6.model.Employee;
import ua.lviv.iot.lab6.repository.EmployeeRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeRepo employeeRepo;
    final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeRepo deviceRepo, EmployeeMapper deviceMapper) {
        this.employeeRepo = deviceRepo;
        this.employeeMapper = deviceMapper;
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable int id) {
        return employeeMapper.convertToDto(employeeRepo.getOne(id));
    }

    @GetMapping("/")
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDto> deviceDtos = new LinkedList<>();
        for (Employee employee: employees) {
            deviceDtos.add(employeeMapper.convertToDto(employee));
        }
        return deviceDtos;
    }

    @PostMapping("/")
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
        return employeeMapper.convertToDto(employeeRepo.save(employeeMapper.convertToModel(employeeDto)));
    }

    @PutMapping("/")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
        return employeeMapper.convertToDto(employeeRepo.save(employeeMapper.convertToModel(employeeDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeRepo.deleteById(id);
    }

}
