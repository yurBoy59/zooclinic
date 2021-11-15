package com.zooclinic.zooclinic.repo;

import com.zooclinic.zooclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByLogin(String login);
}
