package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.FinancialProductDto;
import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FinancialProductMapper {
    FinancialProduct toEntity(FinancialProductDto financialProductDto);

    FinancialProductDto toDto(FinancialProduct financialProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FinancialProduct partialUpdate(FinancialProductDto financialProductDto, @MappingTarget FinancialProduct financialProduct);
}