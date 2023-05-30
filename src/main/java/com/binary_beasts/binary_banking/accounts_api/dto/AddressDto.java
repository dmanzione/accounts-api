package com.binary_beasts.binary_banking.accounts_api.dto;

import com.binary_beasts.binary_banking.accounts_api.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

/**
 * A DTO for the {@link Address} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
@EqualsAndHashCode
public class AddressDto {
    @Size(max = 10)
    @NotBlank(message = "Zipcode is required")

    private final String zip;
    @NotNull(message = "DateCreated is required")
    private Instant dateCreated;
    @NotBlank(message = "Street address is required")
    private String street1;
    private String street2;
    @NotBlank(message = "City is required")
    private String city;
    @Size(max = 2)
    @NotBlank(message = "State is required")
    private String state;
}