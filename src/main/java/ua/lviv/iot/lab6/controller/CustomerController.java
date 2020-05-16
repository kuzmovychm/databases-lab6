package ua.lviv.iot.lab6.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab6.dto.CustomerDto;
import ua.lviv.iot.lab6.mapper.impl.CustomerMapper;
import ua.lviv.iot.lab6.model.Customer;
import ua.lviv.iot.lab6.repository.CustomerRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    final CustomerRepo customerRepo;
    final CustomerMapper customerMapper;

    public CustomerController(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable int id) {
        return customerMapper.convertToDto(customerRepo.getOne(id));
    }

    @GetMapping("/")
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDto> customerDtos = new LinkedList<>();
        for (Customer customer: customers) {
            customerDtos.add(customerMapper.convertToDto(customer));
        }
        return customerDtos;
    }

    @PostMapping("/")
    public CustomerDto create(@RequestBody CustomerDto customerDto) {
        return customerMapper.convertToDto(customerRepo.save(customerMapper.convertToModel(customerDto)));
    }

    @PutMapping("/")
    public CustomerDto update(@RequestBody CustomerDto customerDto) {
        return customerMapper.convertToDto(customerRepo.save(customerMapper.convertToModel(customerDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        customerRepo.deleteById(id);
    }

}
