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

    @PostMapping("/addViaParameters")
    public String addNurseByParameters(@RequestParam("nurseId") Integer nurseId,
                                       @RequestParam("name") String name,
                                       @RequestParam("qualification") String qualification,
                                       @RequestParam("age") Integer age) {

        Nurse nurse = new Nurse(nurseId, name, qualification, age);

        String message = addNurse(nurse);
        return message;
    }

    @PostMapping("/addViaPathVariable/{nurseId}/{name}/{qualification}/{age}")
    public String addNurseByPathVariables(@PathVariable("nurseId") Integer nurseId,
                                          @PathVariable("qualification") String qualification,
                                          @PathVariable("name") String name,
                                          @PathVariable("age") Integer age) {

        Nurse nurse = new Nurse(nurseId, name, qualification, age);

        String message = addNurse(nurse);
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

    @PutMapping("/update")
    public String updateNurse(@RequestBody Nurse nurse) {

        String message = nurseService.updateNurse(nurse);
        return message;
    }

    @PutMapping("/updateQualification")
    public String updateNurseQualification(@RequestParam("nurseId") Integer nurseId,
                                           @RequestParam("qualification") String qualification) {

        String message = nurseService.updateNurseQualification(nurseId, qualification);
        return message;
    }

    @PutMapping("/updateQualification/{nurseId}/{qualification}")
    public String updateNurseQualificationByPathVariable(@PathVariable("nurseId") Integer nurseId,
                                           @PathVariable("qualification") String qualification) {

        String message = updateNurseQualification(nurseId, qualification);
        return message;
    }

}
