package io.pragra.learning.feb25jpa.repo;

import io.pragra.learning.feb25jpa.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Integer> {
}
