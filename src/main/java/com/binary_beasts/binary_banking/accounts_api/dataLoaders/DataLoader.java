//package com.binary_beasts.binary_banking.accounts_api.dataLoaders;
//
//import com.binary_beasts.binary_banking.accounts_api.model.*;
//import com.binary_beasts.binary_banking.accounts_api.repository.AccountRepository;
//import com.binary_beasts.binary_banking.accounts_api.repository.AddressRepository;
//import com.binary_beasts.binary_banking.accounts_api.repository.UserRepository;
//import com.binary_beasts.binary_banking.accounts_api.service.AccountService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.Instant;
//import java.util.Random;
//import java.util.UUID;
//
//@Configuration
//
//public class DataLoader {
//
//
//    @Bean
//    CommandLineRunner loadAccounts(
//            UserRepository userRepository,
//            AccountRepository accountRepository, AccountService accountService, AddressRepository addressRepository) {
//
//        return args -> {
//            if (addressRepository.count() == 0) {
//                for (long i = 1; i <= 20; i++) {
//                    Address address = new Address();
//                    address.setCity("MyCity" + i);
//                    address.setState(String.valueOf(i));
//                    address.setZip("66666");
//                    address.setStreet1("StreetOne" + i);
//                    address.setPk(i);
//                    address.setDateCreated(Instant.now());
//                    addressRepository.save(address);
//                }
//            }
//            if (userRepository.count() == 0) {
//                for (long i = 1; i <= 20; i++) {
//                    User user = new User();
//                    user.setPk(i);
//                    user.setFirstName("Mock" + i);
//                    user.setLastName("Last" + i);
//
//
//                    user.setAddress(addressRepository.findById(i).get());
//                    user.setEmail("email" + i + "@email.com");
//                    user.setPassword("passworD-" + i);
//                    user.setDateCreated(Instant.now());
//                    user.setRole(1L);
//                    user.setPhone("555-555-5555");
//                    user.setId(UUID.randomUUID().toString());
//                    userRepository.save(user);
//                }
//            }
//            if (accountRepository.count() == 0) {
//                int j = 0;
//
//                for (long i = 7; i <= 26; i++, i++) {
//
//                    Account account = new Account();
//                    account.setAccountNumber(UUID
//                            .randomUUID()
//                            .toString());
//                    account.setRate(new Random().nextDouble());
//                    account.setBalance(new Random().nextLong(
//                            500,
//                            10_000));
//                    account.setOwner(i);
//                    account.setDateCreated(Instant.now());
//                    account.setType(AccountType.values()[j]);
//                    account.setStatus(AccountStatus.OPEN);
//                    account.setPk(new Random().nextLong());
//                    accountService.openAccount(account);
//
//                    if (j == 3) {
//                        j = 0;
//                    } else {
//                        j++;
//                    }
//                }
//
//            }
//
//        };
//    }
//
//}
