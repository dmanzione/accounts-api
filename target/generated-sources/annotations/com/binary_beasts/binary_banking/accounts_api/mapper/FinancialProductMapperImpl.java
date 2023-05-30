package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.FinancialProductDto;
import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class FinancialProductMapperImpl implements FinancialProductMapper {

    @Override
    public FinancialProduct toEntity(FinancialProductDto financialProductDto) {
        if ( financialProductDto == null ) {
            return null;
        }

        FinancialProduct financialProduct = new FinancialProduct();

        if ( financialProductDto.getId() != null ) {
            financialProduct.setId( String.valueOf( financialProductDto.getId() ) );
        }
        financialProduct.setName( financialProductDto.getName() );
        financialProduct.setDescription( financialProductDto.getDescription() );

        return financialProduct;
    }

    @Override
    public FinancialProductDto toDto(FinancialProduct financialProduct) {
        if ( financialProduct == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;

        if ( financialProduct.getId() != null ) {
            id = Long.parseLong( financialProduct.getId() );
        }
        name = financialProduct.getName();
        description = financialProduct.getDescription();

        FinancialProductDto financialProductDto = new FinancialProductDto( id, name, description );

        return financialProductDto;
    }

    @Override
    public FinancialProduct partialUpdate(FinancialProductDto financialProductDto, FinancialProduct financialProduct) {
        if ( financialProductDto == null ) {
            return financialProduct;
        }

        if ( financialProductDto.getId() != null ) {
            financialProduct.setId( String.valueOf( financialProductDto.getId() ) );
        }
        if ( financialProductDto.getName() != null ) {
            financialProduct.setName( financialProductDto.getName() );
        }
        if ( financialProductDto.getDescription() != null ) {
            financialProduct.setDescription( financialProductDto.getDescription() );
        }

        return financialProduct;
    }
}
