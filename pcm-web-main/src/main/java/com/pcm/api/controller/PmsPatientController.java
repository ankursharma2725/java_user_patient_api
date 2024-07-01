package com.pcm.api.controller;

import com.pcm.api.dto.PmsPatientVitalsDto;
import com.pcm.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitals")
public class PmsPatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<PmsPatientVitalsDto> getAllData() {
        return patientService.getAllData();
    }


//    @GetMapping("/test")
//    public List<PmsPatientVitals> test() {
//        return patientService.test();
//    }


    @GetMapping("/patient/{id}")
    public PmsPatientVitalsDto getUserById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/cp")
    public PmsPatientVitalsDto insertPatient(@RequestBody PmsPatientVitalsDto pmsPatientVitalsDto) {
        return patientService.insertPatient(pmsPatientVitalsDto);
    }

    @PutMapping("/up/{id}")
    public PmsPatientVitalsDto updateUser(@RequestBody PmsPatientVitalsDto patient, @PathVariable int id) {
        return patientService.updatePatient(patient, id);
    }

    @DeleteMapping("/removeAll")
    public void removeUser() {
        patientService.removePatient();
    }

    @DeleteMapping("/remove/{id}")
    public void removeUserById(@PathVariable int id) {
        patientService.removePatientById(id);
    }


}
