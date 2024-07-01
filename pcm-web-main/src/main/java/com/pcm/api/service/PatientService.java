package com.pcm.api.service;

import com.pcm.api.dto.PmsPatientVitalsDto;
import com.pcm.api.dto.PmsUserDto;
import com.pcm.api.entity.PmsPatientVitals;
import com.pcm.api.entity.PmsUser;
import com.pcm.api.entity.UserType;
import com.pcm.api.repository.PmsPatientVitalsRepository;
import com.pcm.api.repository.PmsUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {


    @Autowired
    private PmsUserRepository pmsUserRepo;

    @Autowired
    private PmsPatientVitalsRepository pmsPatientVitalsRepo;
    // add repository to call save on the patient vitals
//    public void addPatientVitals(){
//
//    }

    @Autowired
    private ModelMapper modelMapper;

    public List<PmsPatientVitalsDto> getAllData() {
        List<PmsPatientVitalsDto> patientDtos = pmsPatientVitalsRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, PmsPatientVitalsDto.class))
                .collect(Collectors.toList());
        return patientDtos;
    }

    public PmsPatientVitalsDto getPatientById(long id) {
        pmsPatientVitalsRepo.findById(id);
        PmsPatientVitals patient = pmsPatientVitalsRepo.findById(id).get();
        return modelMapper.map(patient, PmsPatientVitalsDto.class);
    }

    public PmsPatientVitalsDto insertPatient(PmsPatientVitalsDto pmsPatientVitalsDto) {
//        return pmsPatientVitalsRepo.save(pmsPatientVitals);
        PmsPatientVitals patient = modelMapper.map(pmsPatientVitalsDto, PmsPatientVitals.class);

        patient.setCreatedDate(LocalDateTime.now());
        patient.setUpdatedDate(LocalDateTime.now());
        patient.getPid().setUpdatedDate(LocalDateTime.now());
        patient.getPid().setCreatedDate(LocalDateTime.now());

        if (pmsPatientVitalsDto.getPid().getType() == UserType.P) {

            pmsPatientVitalsRepo.save(patient);
            return modelMapper.map(patient, PmsPatientVitalsDto.class);

        } else {
            if (isValidUserType(pmsPatientVitalsDto.getPid().getType())) {
                PmsUser data = pmsPatientVitalsDto.getPid();
                pmsUserRepo.save(data);
                return pmsPatientVitalsDto;

            }
            else {
                throw new IllegalArgumentException("Invalid user type");
            }
        }

    }


public PmsPatientVitalsDto updatePatient(PmsPatientVitalsDto pmsPatientVitalsDto, long id) {
    PmsPatientVitals patient = pmsPatientVitalsRepo.findById(id).get();
    if (patient != null) {

        patient.setBpLw(pmsPatientVitalsDto.getBpLw());
        patient.setBpU(pmsPatientVitalsDto.getBpU());
        patient.setTemperature(pmsPatientVitalsDto.getTemperature());
        patient.setUpdatedDate(LocalDateTime.now());
        patient.getPid().setUpdatedDate(LocalDateTime.now());
        patient.setMessage(pmsPatientVitalsDto.getMessage());


        pmsPatientVitalsRepo.save(patient);
        return modelMapper.map(patient, PmsPatientVitalsDto.class);
    }
    return null;
}

public void removePatient() {
    pmsPatientVitalsRepo.deleteAll();
}

public void removePatientById(long id) {
    pmsPatientVitalsRepo.deleteById(id);
}


private boolean isValidUserType(UserType type) {
    // Add any additional validation logic for other user types if needed
    // For now, it just returns true for non-UserType.P
    return type == UserType.N || type == UserType.A || type == UserType.SA;
}
}



