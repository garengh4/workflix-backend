package com.infy.workflix.repository;

import com.infy.workflix.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, String>{

    @Query("SELECT p FROM Profile p WHERE p.emailId = ?1")
    public List<Profile> findByEmailId(String emailID);

}
