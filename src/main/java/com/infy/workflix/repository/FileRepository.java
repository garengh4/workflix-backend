package com.infy.workflix.repository;

import com.infy.workflix.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FileRepository extends JpaRepository<File,Long> {

    public Set<File>findByCategoryName(String categoryName);
    public Set<File>findByUserProfileId(String userProfileId);
    public Set<File>findByFileName(String fileName);

}
