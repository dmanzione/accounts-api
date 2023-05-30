package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.EmployeeDto;
import com.binary_beasts.binary_banking.accounts_api.model.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T11:43:30-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setUser( employeeDto.getUser() );

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        Long id = null;
        Long user = null;

        id = employee.getId();
        user = employee.getUser();

        EmployeeDto employeeDto = new EmployeeDto( id, user );

        return employeeDto;
    }

    @Override
    public Employee partialUpdate(EmployeeDto employeeDto, Employee employee) {
        if ( employeeDto == null ) {
            return employee;
        }

        if ( employeeDto.getId() != null ) {
            employee.setId( employeeDto.getId() );
        }
        if ( employeeDto.getUser() != null ) {
            employee.setUser( employeeDto.getUser() );
        }

        return employee;
    }
}
