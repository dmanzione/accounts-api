package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.AddressDto;
import com.binary_beasts.binary_banking.accounts_api.dto.UserDto;
import com.binary_beasts.binary_banking.accounts_api.model.Address;
import com.binary_beasts.binary_banking.accounts_api.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setPk( userDto.getPk() );
        user.setId( userDto.getId() );
        user.setRole( userDto.getRole() );
        user.setDateCreated( userDto.getDateCreated() );
        user.setPassword( userDto.getPassword() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPhone( userDto.getPhone() );
        user.setStatus( userDto.getStatus() );
        user.setAddress( addressDtoToAddress( userDto.getAddress() ) );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setPk( user.getPk() );
        userDto.setId( user.getId() );
        userDto.setRole( user.getRole() );
        userDto.setPassword( user.getPassword() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhone( user.getPhone() );
        userDto.setStatus( user.getStatus() );
        userDto.setAddress( addressToAddressDto( user.getAddress() ) );

        return userDto;
    }

    @Override
    public User partialUpdate(UserDto userDto, User user) {
        if ( userDto == null ) {
            return user;
        }

        if ( userDto.getPk() != null ) {
            user.setPk( userDto.getPk() );
        }
        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( userDto.getRole() != null ) {
            user.setRole( userDto.getRole() );
        }
        if ( userDto.getDateCreated() != null ) {
            user.setDateCreated( userDto.getDateCreated() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
        if ( userDto.getFirstName() != null ) {
            user.setFirstName( userDto.getFirstName() );
        }
        if ( userDto.getLastName() != null ) {
            user.setLastName( userDto.getLastName() );
        }
        if ( userDto.getEmail() != null ) {
            user.setEmail( userDto.getEmail() );
        }
        if ( userDto.getPhone() != null ) {
            user.setPhone( userDto.getPhone() );
        }
        if ( userDto.getStatus() != null ) {
            user.setStatus( userDto.getStatus() );
        }
        if ( userDto.getAddress() != null ) {
            if ( user.getAddress() == null ) {
                user.setAddress( new Address() );
            }
            addressDtoToAddress1( userDto.getAddress(), user.getAddress() );
        }

        return user;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setDateCreated( addressDto.getDateCreated() );
        address.setStreet1( addressDto.getStreet1() );
        address.setStreet2( addressDto.getStreet2() );
        address.setCity( addressDto.getCity() );
        address.setState( addressDto.getState() );
        address.setZip( addressDto.getZip() );

        return address;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setDateCreated( address.getDateCreated() );
        addressDto.setStreet1( address.getStreet1() );
        addressDto.setStreet2( address.getStreet2() );
        addressDto.setCity( address.getCity() );
        addressDto.setState( address.getState() );

        return addressDto;
    }

    protected void addressDtoToAddress1(AddressDto addressDto, Address mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        mappingTarget.setDateCreated( addressDto.getDateCreated() );
        mappingTarget.setStreet1( addressDto.getStreet1() );
        mappingTarget.setStreet2( addressDto.getStreet2() );
        mappingTarget.setCity( addressDto.getCity() );
        mappingTarget.setState( addressDto.getState() );
        mappingTarget.setZip( addressDto.getZip() );
    }
}
