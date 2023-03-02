package com.infy.workflix.repository;

import com.infy.workflix.entity.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, String>{

    public List<Profile> findByEmailId(String emailID);

}
