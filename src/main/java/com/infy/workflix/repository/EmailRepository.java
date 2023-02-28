package com.infy.workflix.repository;

import com.infy.workflix.entity.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email,String>{


}
