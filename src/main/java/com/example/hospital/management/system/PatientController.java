package com.example.hospital.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class PatientController {

    HashMap<Integer, Patient> patientHashMap = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam("patientId") Integer patientId,
                             @RequestParam("name") String name,
                             @RequestParam("age") Integer age,
                             @RequestParam("disease") String disease) {

        Patient patient = new Patient(patientId, name, age, disease);

        patientHashMap.put(patientId, patient);

        return "Patient added via parameters successfully";
    }

    @PostMapping("/addPatientViaBody")
    public String addPatient(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        patientHashMap.put(key, patient);

        return "Patient added successfully via body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId) {

        Patient patient = patientHashMap.get(patientId);

        return patient;
    }
}
