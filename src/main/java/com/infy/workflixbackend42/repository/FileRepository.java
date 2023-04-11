package com.infy.workflixbackend42.repository;

import com.infy.workflixbackend42.entity.InputFile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FileRepository extends JpaRepository<InputFile,Long> {
    public Set<InputFile>findByCategoryName(String categoryName);
    public Set<InputFile>findByProfileId(String profileId);
    public InputFile findByFileName(String fileName);
    public InputFile findByFileId(long fileId);
}