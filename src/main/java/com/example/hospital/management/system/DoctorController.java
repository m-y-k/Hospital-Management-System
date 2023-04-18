package com.example.hospital.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    HashMap<Integer, Doctor> doctorHashMap = new HashMap<>();

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {

        int key = doctor.getDoctorId();

        doctorHashMap.put(key, doctor);

        return "Doctor added via body";
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("doctorId") Integer doctorId) {

        if (doctorHashMap.containsKey(doctorId)) {

            Doctor doctor = doctorHashMap.get(doctorId);
            return doctor;
        }
        else {
            return null;
        }
    }

}
