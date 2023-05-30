package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long pk;

    @NotNull
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "role")
    private Long role;

    @Column(name = "date_created")
    private Instant dateCreated;

    @NotBlank(message = "Password field cannot be blank")
    @Size(min = 8, max = 16, message = "Password must be between 8 alphanumeric characters")
    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @NotBlank(message = "First name field is required")
    @Column(name = "first_name", nullable = false, length = Integer.MAX_VALUE)
    private String firstName;

    @NotBlank(message = "Last name field is required")
    @Column(name = "last_name", nullable = false, length = Integer.MAX_VALUE)
    private String lastName;


    @Email(message = "Email field is required")
    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @NotBlank(message = "Phone is a required field")
    @Column(name = "phone", nullable = false, length = Integer.MAX_VALUE)
    private String phone;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address")
    private Address address;


    Instant getDateCreated() {
        if (dateCreated == null) {
            return dateCreated = Instant.now();
        } else return dateCreated;
    }
}