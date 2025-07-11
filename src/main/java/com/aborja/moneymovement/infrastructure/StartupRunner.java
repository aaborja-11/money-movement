package com.aborja.moneymovement.infrastructure;

import com.aborja.moneymovement.business.entities.Business;
import com.aborja.moneymovement.business.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public void run(String... args) {
        final var businessId = UUID.fromString("6511b0c5-c388-4ee8-8669-4c34f74683b3");
        final var newBusiness = Business.builder().name("My Furry Paws")
                .updatedBy("TESTTTTING!!").build();
        //newBusiness.setId(businessId);
        //newBusiness.setVersion(0L);

        final var business = businessRepository.findById(UUID.fromString("9fa20f34-0cb3-4f42-962e-02dd211e5e13")).orElse(newBusiness);
        business.setName("Updated Name 1");
        business.setCreatedBy("TEST");
        final var saved = businessRepository.save(business);
        int x = 1;
    }
}
