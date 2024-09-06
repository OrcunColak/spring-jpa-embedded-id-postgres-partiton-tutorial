package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.SecurityPrice;
import com.colak.springtutorial.jpa.SecurityPriceId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SecurityPriceRepositoryTest {

    @Autowired
    private SecurityPriceRepository repository;

    @Test
    void findById() {

        // select ... from security_prices sp where (sp.business_date,sp.id) in ((?,?))
        LocalDate businessDate = LocalDate.parse("2024-03-19");
        SecurityPriceId securityPriceId = new SecurityPriceId("1", businessDate);

        Optional<SecurityPrice> optional = repository.findById(securityPriceId);

        assertThat(optional).isNotEmpty();
        SecurityPrice securityPrice = optional.get();
        assertThat(securityPrice.getSecurityId()).isEqualTo("IBM");
    }
}
