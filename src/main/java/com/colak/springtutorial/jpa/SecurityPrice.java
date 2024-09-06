package com.colak.springtutorial.jpa;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "security_prices")

@Getter
@Setter
public class SecurityPrice {

    // If you choose to add a PK to a partitioned table (which I suggest you should), the PK must include the partition key.
    // In our case, since business_date is the partition key, if you were to add a PK, it would need to include
    // business_date along with other columns to ensure uniqueness across all partitions.
    // For instance, you could define a composite primary key that includes both id and business_date:
    // CREATE TABLE security_prices (…, PRIMARY KEY (id, business_date);.
    // In this case, you can create a composite key (which will include both Id and BusinessDate) using
    // @Embeddable and embed it in your entity using @EmbeddedId
    @EmbeddedId
    private SecurityPriceId id;

    private String securityId;

    private BigDecimal price;

}