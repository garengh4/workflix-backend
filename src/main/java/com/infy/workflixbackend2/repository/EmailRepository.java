package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,String> {

}
