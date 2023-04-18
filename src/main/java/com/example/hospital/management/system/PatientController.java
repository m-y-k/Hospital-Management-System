package com.example.hospital.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/patient")
public class PatientController {

    HashMap<Integer, Patient> patientHashMap = new HashMap<>();

    @PostMapping("/addViaParameters")
    public String addPatient(@RequestParam("patientId") Integer patientId,
                             @RequestParam("name") String name,
                             @RequestParam("age") Integer age,
                             @RequestParam("disease") String disease) {

        Patient patient = new Patient(patientId, name, age, disease);

        patientHashMap.put(patientId, patient);

        return "Patient added via parameters successfully";
    }

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        patientHashMap.put(key, patient);

        return "Patient added successfully via body";
    }

    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId) {

        Patient patient = patientHashMap.get(patientId);

        return patient;
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            patients.add(patient);
        }

        return patients;
    }

    @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam("name") String name) {

        for (Patient patient : patientHashMap.values()) {

            if (patient.getName().equals(name)) {
                return patient;
            }
        }

        return null;
    }

    @GetMapping("getListGreaterThanAge")
    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age") Integer age) {

        List<Patient> patients = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            if (patient.getAge() > age) {
                patients.add(patient);
            }
        }

        return patients;
    }

    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getInfoViaPathVariable(@PathVariable("patientId") Integer patientId) {

        if (patientHashMap.containsKey(patientId)) {

            Patient patient = patientHashMap.get(patientId);
            return patient;
        }
        else {
            return null;
        }
    }

    @GetMapping("/getInfoViaPathVariables/{age}/{disease}")
    public List<Patient> getInfoViaPathVariables(@PathVariable("age") Integer age,
                                                 @PathVariable("disease") String disease) {

        List<Patient> patientList = new ArrayList<>();

        for (Patient patient : patientHashMap.values()) {

            if (patient.getAge() > age && patient.getDisease().equals(disease)) {

                patientList.add(patient);
            }
        }
        return patientList;
    }

    @PutMapping("/update")
    public String updatePatientDetails(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        if (patientHashMap.containsKey(key)) {

            patientHashMap.put(key, patient);
            return "Patient details updated successfully";
        }

        return "Patient not found";
    }

    @PutMapping("/updateViaParameters")
    public String updatePatientByParameters(@RequestParam("patientId") Integer patientId,
                                            @RequestParam("name") String name,
                                            @RequestParam("age") Integer age,
                                            @RequestParam("disease") String disease) {

        if (patientHashMap.containsKey(patientId)) {

            Patient patient = patientHashMap.get(patientId);

            patient.setName(name);
            patient.setAge(age);
            patient.setDisease(disease);

            patientHashMap.put(patientId, patient);

            return "details updated";
        }
        else {
            return "Not found";
        }
    }

    @PutMapping("/updateViaDisease")
    public String updatePatientDisease(@RequestParam("patientId") Integer patientId,
                                       @RequestParam("disease") String disease) {

        if (patientHashMap.containsKey(patientId)) {

            Patient patient = patientHashMap.get(patientId);

            patient.setDisease(disease);
            patientHashMap.put(patientId, patient);

            return "Disease updated";
        }
        return "Record not found";
    }

    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId") Integer patientId) {

        for (Integer key : patientHashMap.keySet()) {

            Patient patient = patientHashMap.get(key);

            if (patient.getPatientId() == patientId) {

                patientHashMap.remove(key);
                return "Patient removed";
            }
        }

        return "Not found";

    }
}
