package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {

}
