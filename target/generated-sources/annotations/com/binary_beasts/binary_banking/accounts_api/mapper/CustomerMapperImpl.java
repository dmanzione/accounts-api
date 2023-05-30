package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.CustomerDto;
import com.binary_beasts.binary_banking.accounts_api.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T11:43:30-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setUser( customerDto.getUser() );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long id = null;
        Long user = null;

        id = customer.getId();
        user = customer.getUser();

        CustomerDto customerDto = new CustomerDto( id, user );

        return customerDto;
    }

    @Override
    public Customer partialUpdate(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return customer;
        }

        if ( customerDto.getId() != null ) {
            customer.setId( customerDto.getId() );
        }
        if ( customerDto.getUser() != null ) {
            customer.setUser( customerDto.getUser() );
        }

        return customer;
    }
}
