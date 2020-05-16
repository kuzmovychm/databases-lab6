package ua.lviv.iot.lab6.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.lab6.dto.CustomerDto;
import ua.lviv.iot.lab6.mapper.GeneralMapper;
import ua.lviv.iot.lab6.model.Customer;

@Component
public class CustomerMapper implements GeneralMapper<Customer, CustomerDto> {

    @Override
    public CustomerDto convertToDto(Customer model) {
        return CustomerDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .secondName(model.getSecondName())
                .phoneNumber(model.getPhoneNumber())
                .build();
    }

    @Override
    public Customer convertToModel(CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}
