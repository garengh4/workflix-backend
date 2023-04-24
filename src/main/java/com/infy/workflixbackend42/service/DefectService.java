package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.DefectDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DefectService {
    public List<DefectDTO> getAllDefects();

    public Integer addDefect(DefectDTO defectDTO) throws WorkflixException;

}
