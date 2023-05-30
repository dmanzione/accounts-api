package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.LoanDto;
import com.binary_beasts.binary_banking.accounts_api.model.Loan;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AccountMapper.class})
public interface LoanMapper {
    Loan toEntity(LoanDto loanDto);

    LoanDto toDto(Loan loan);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Loan partialUpdate(LoanDto loanDto, @MappingTarget Loan loan);
}