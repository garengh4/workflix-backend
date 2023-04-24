package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.DefectDTO;
import com.infy.workflixbackend42.entity.Defect;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.repository.DefectRepository;
import com.infy.workflixbackend42.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "defectService")
@Transactional
public class DefectServiceImpl implements DefectService{
    @Autowired
    private DefectRepository defectRepository;
    @Override
    public List<DefectDTO> getAllDefects() {
        List<Defect> defects = defectRepository.findAll();
        List<DefectDTO> defectDTOS = defects.stream().map(x ->{
            DefectDTO defectDTO = new DefectDTO();
            defectDTO.setDefectId(x.getDefectId());
            defectDTO.setCategory(x.getCategory());
            defectDTO.setPriority(x.getPriority());
            defectDTO.setStatus(x.getStatus());
            defectDTO.setDescription(x.getDescription());
            return defectDTO;
        }).collect(Collectors.toList());

        return defectDTOS;
    }

    @Override
    public Integer addDefect(DefectDTO defectDTO) throws WorkflixException {
        Defect defect = new Defect();
        defect.setCategory(defectDTO.getCategory());
        defect.setPriority(defectDTO.getPriority());
        defect.setStatus(defectDTO.getStatus());
        defect.setDescription(defectDTO.getDescription());
        // to extract new GENERATIONTYPE.AUTO defect.id
        Defect defectFromDB = defectRepository.save(defect);
        return defectFromDB.getDefectId();
    }
}
