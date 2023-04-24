package com.infy.workflixbackend42.repository;

import com.infy.workflixbackend42.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends JpaRepository<Defect,Integer> {
}
