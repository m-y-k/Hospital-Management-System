package com.example.hospital.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            patients.add(patient);
        }

        return patients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name) {

        for (Patient patient : patientHashMap.values()) {

            if (patient.getName().equals(name)) {
                return patient;
            }
        }

        return null;
    }

    @GetMapping("getPatientsListGreaterThanAge")
    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age") Integer age) {

        List<Patient> patients = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            if (patient.getAge() > age) {
                patients.add(patient);
            }
        }

        return patients;
    }
}
