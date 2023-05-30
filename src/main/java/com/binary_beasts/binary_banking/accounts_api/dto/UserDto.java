package com.binary_beasts.binary_banking.accounts_api.dto;

import com.binary_beasts.binary_banking.accounts_api.model.User;
import com.binary_beasts.binary_banking.accounts_api.model.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

/**
 * A DTO for the {@link User} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {
    private Long pk;
    private String id;
    private Long role;
    private Instant dateCreated;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    private String status;
    private AddressDto address;
}