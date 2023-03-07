package com.infy.workflix.repository;

import com.infy.workflix.entity.InputFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FileRepository extends JpaRepository<InputFile,Long> {

    public Set<InputFile>findByCategoryName(String categoryName);
    public Set<InputFile>findByUserProfileId(String userProfileId);
    public Set<InputFile>findByFileName(String fileName);

}
