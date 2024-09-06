package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.SecurityPrice;
import com.colak.springtutorial.jpa.SecurityPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityPriceRepository extends JpaRepository<SecurityPrice, SecurityPriceId> {
}
