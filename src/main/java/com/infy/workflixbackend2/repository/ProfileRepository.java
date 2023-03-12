package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, String>{

    @Query("SELECT p FROM Profile p WHERE p.emailId = ?1")
    public List<Profile> findByEmailId(String emailID);
}
