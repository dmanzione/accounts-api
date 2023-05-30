package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.CardDto;
import com.binary_beasts.binary_banking.accounts_api.dto.UserDto;
import com.binary_beasts.binary_banking.accounts_api.model.Account;
import com.binary_beasts.binary_banking.accounts_api.model.Card;
import com.binary_beasts.binary_banking.accounts_api.model.User;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class CardMapperImpl implements CardMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Card toEntity(CardDto cardDto) {
        if ( cardDto == null ) {
            return null;
        }

        Card card = new Card();

        if ( cardDto.getId() != null ) {
            card.setId( String.valueOf( cardDto.getId() ) );
        }
        card.setAccount( cardDto.getAccount() );
        card.setName( cardDto.getName() );
        card.setDescription( cardDto.getDescription() );
        card.setDateCreated( cardDto.getDateCreated() );
        card.setUser( userMapper.toEntity( cardDto.getUser() ) );
        card.setCardholderName( cardDto.getCardholderName() );
        card.setCardNumber( cardDto.getCardNumber() );
        card.setStatus( cardDto.getStatus() );

        return card;
    }

    @Override
    public CardDto toDto(Card card) {
        if ( card == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        Instant dateCreated = null;
        UserDto user = null;
        Account account = null;
        String cardholderName = null;
        String cardNumber = null;
        Object status = null;

        if ( card.getId() != null ) {
            id = Long.parseLong( card.getId() );
        }
        name = card.getName();
        description = card.getDescription();
        dateCreated = card.getDateCreated();
        user = userMapper.toDto( card.getUser() );
        account = card.getAccount();
        cardholderName = card.getCardholderName();
        cardNumber = card.getCardNumber();
        status = card.getStatus();

        CardDto cardDto = new CardDto( id, name, description, dateCreated, user, account, cardholderName, cardNumber, status );

        return cardDto;
    }

    @Override
    public Card partialUpdate(CardDto cardDto, Card card) {
        if ( cardDto == null ) {
            return card;
        }

        if ( cardDto.getId() != null ) {
            card.setId( String.valueOf( cardDto.getId() ) );
        }
        if ( cardDto.getAccount() != null ) {
            card.setAccount( cardDto.getAccount() );
        }
        if ( cardDto.getName() != null ) {
            card.setName( cardDto.getName() );
        }
        if ( cardDto.getDescription() != null ) {
            card.setDescription( cardDto.getDescription() );
        }
        if ( cardDto.getDateCreated() != null ) {
            card.setDateCreated( cardDto.getDateCreated() );
        }
        if ( cardDto.getUser() != null ) {
            if ( card.getUser() == null ) {
                card.setUser( new User() );
            }
            userMapper.partialUpdate( cardDto.getUser(), card.getUser() );
        }
        if ( cardDto.getCardholderName() != null ) {
            card.setCardholderName( cardDto.getCardholderName() );
        }
        if ( cardDto.getCardNumber() != null ) {
            card.setCardNumber( cardDto.getCardNumber() );
        }
        if ( cardDto.getStatus() != null ) {
            card.setStatus( cardDto.getStatus() );
        }

        return card;
    }
}
