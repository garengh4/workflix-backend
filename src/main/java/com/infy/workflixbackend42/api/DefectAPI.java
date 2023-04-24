package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.DefectDTO;
import com.infy.workflixbackend42.entity.Defect;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/defect-api")
@RestController
@Validated
public class DefectAPI {

    @Autowired
    private DefectService defectService;
    @GetMapping
    public List<DefectDTO> allDefects(){
        return defectService.getAllDefects();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Integer> addDefect(@RequestBody DefectDTO defectDTO) throws WorkflixException{
        Integer newDefectId =  defectService.addDefect(defectDTO);
        return new ResponseEntity<>(newDefectId, HttpStatus.OK);
    }

}
