package com.infy.workflix.repository;

import com.infy.workflix.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,String> {
}
