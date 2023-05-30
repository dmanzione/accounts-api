package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.AccountDto;
import com.binary_beasts.binary_banking.accounts_api.dto.AddressDto;
import com.binary_beasts.binary_banking.accounts_api.dto.UserDto;
import com.binary_beasts.binary_banking.accounts_api.model.Account;
import com.binary_beasts.binary_banking.accounts_api.model.AccountStatus;
import com.binary_beasts.binary_banking.accounts_api.model.AccountType;
import com.binary_beasts.binary_banking.accounts_api.model.Address;
import com.binary_beasts.binary_banking.accounts_api.model.User;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        Long pk = null;
        String number = null;
        Instant dateCreated = null;
        Double balance = null;
        AccountStatus status = null;
        AccountType type = null;
        UserDto bankAgent = null;
        UserDto customer = null;

        pk = account.getPk();
        number = account.getNumber();
        dateCreated = account.getDateCreated();
        balance = account.getBalance();
        status = account.getStatus();
        type = account.getType();
        bankAgent = userToUserDto( account.getBankAgent() );
        customer = userToUserDto( account.getCustomer() );

        AccountDto accountDto = new AccountDto( pk, number, dateCreated, balance, status, type, bankAgent, customer );

        return accountDto;
    }

    @Override
    public Account toEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setPk( accountDto.getPk() );
        account.setNumber( accountDto.getNumber() );
        account.setCustomer( userDtoToUser( accountDto.getCustomer() ) );
        account.setDateCreated( accountDto.getDateCreated() );
        account.setBalance( accountDto.getBalance() );
        account.setStatus( accountDto.getStatus() );
        account.setType( accountDto.getType() );
        account.setBankAgent( userDtoToUser( accountDto.getBankAgent() ) );

        return account;
    }

    @Override
    public Account partialUpdate(AccountDto accountDto, Account account) {
        if ( accountDto == null ) {
            return account;
        }

        if ( accountDto.getPk() != null ) {
            account.setPk( accountDto.getPk() );
        }
        if ( accountDto.getNumber() != null ) {
            account.setNumber( accountDto.getNumber() );
        }
        if ( accountDto.getCustomer() != null ) {
            if ( account.getCustomer() == null ) {
                account.setCustomer( new User() );
            }
            userDtoToUser1( accountDto.getCustomer(), account.getCustomer() );
        }
        if ( accountDto.getDateCreated() != null ) {
            account.setDateCreated( accountDto.getDateCreated() );
        }
        if ( accountDto.getBalance() != null ) {
            account.setBalance( accountDto.getBalance() );
        }
        if ( accountDto.getStatus() != null ) {
            account.setStatus( accountDto.getStatus() );
        }
        if ( accountDto.getType() != null ) {
            account.setType( accountDto.getType() );
        }
        if ( accountDto.getBankAgent() != null ) {
            if ( account.getBankAgent() == null ) {
                account.setBankAgent( new User() );
            }
            userDtoToUser1( accountDto.getBankAgent(), account.getBankAgent() );
        }

        return account;
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

    protected UserDto userToUserDto(User user) {
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

    protected User userDtoToUser(UserDto userDto) {
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

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        mappingTarget.setPk( userDto.getPk() );
        mappingTarget.setId( userDto.getId() );
        mappingTarget.setRole( userDto.getRole() );
        mappingTarget.setDateCreated( userDto.getDateCreated() );
        mappingTarget.setPassword( userDto.getPassword() );
        mappingTarget.setFirstName( userDto.getFirstName() );
        mappingTarget.setLastName( userDto.getLastName() );
        mappingTarget.setEmail( userDto.getEmail() );
        mappingTarget.setPhone( userDto.getPhone() );
        mappingTarget.setStatus( userDto.getStatus() );
        if ( userDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( userDto.getAddress(), mappingTarget.getAddress() );
        }
        else {
            mappingTarget.setAddress( null );
        }
    }
}
