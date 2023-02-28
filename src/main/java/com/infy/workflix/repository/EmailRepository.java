package com.infy.workflix.repository;

import com.infy.workflix.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,String>{

}
