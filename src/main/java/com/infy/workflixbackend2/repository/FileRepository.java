package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.InputFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface FileRepository extends JpaRepository<InputFile,Long> {

    public Set<InputFile>findByCategoryName(String categoryName);
    public Set<InputFile>findByUserProfileId(String userProfileId);
    public InputFile findByFileName(String fileName);
    public InputFile findByFileId(long fileId);
}
