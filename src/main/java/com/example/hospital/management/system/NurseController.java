package com.example.hospital.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    NurseService nurseService = new NurseService();

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse) {

        String message = nurseService.addNurse(nurse);
        return message;
    }

    @GetMapping("/getAll")
    public List<Nurse> getNurse() {

        List<Nurse> nurses = nurseService.getAll();
        return nurses;
    }

    @GetMapping("/getByAge")
    public List<Nurse> getNurseByAge(@RequestParam("age") Integer age) {

        List<Nurse> nurses = nurseService.getNurseByAge(age);
        return nurses;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNurseByQualification(@RequestParam("qualification") String qualification) {

        List<Nurse> nurses = nurseService.getNurseByQualification(qualification);
        return nurses;
    }
}
