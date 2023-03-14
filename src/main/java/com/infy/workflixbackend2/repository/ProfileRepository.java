package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfileRepository extends JpaRepository<Profile,String>{}
