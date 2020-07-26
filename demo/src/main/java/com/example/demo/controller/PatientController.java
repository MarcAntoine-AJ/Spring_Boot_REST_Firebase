package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ExecutionException;
@RequestMapping("api/v1/patient")
@RestController
public class PatientController {

    PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path="{name}")
    public Patient getPatient(@PathVariable("name") String name ) throws InterruptedException, ExecutionException{
        return patientService.getPatientDetails(name);
    }

    @PostMapping(consumes = "application/json")
    public String createPatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
        System.out.println(patient.getName());
        return patientService.savePatientDetails(patient);
    }

    @PutMapping
    public String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping(path= "{name}")
    public String deletePatient(@PathVariable("name") String name){
        return patientService.deletePatient(name);
    }
}