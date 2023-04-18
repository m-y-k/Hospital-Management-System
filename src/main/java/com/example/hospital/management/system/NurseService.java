package com.example.hospital.management.system;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse) {

        String message = nurseRepository.addNurse(nurse);
        return message;
    }

    public List<Nurse> getAll() {

        return nurseRepository.getAll();
    }

    public List<Nurse> getNurseByAge(Integer age) {

        List<Nurse> nurseList = new ArrayList<>();

        // we will ask for all nurses list
        // then filter it by our priority
        // and send it to controller layer
        List<Nurse> nurses = nurseRepository.getAll();

        for (Nurse nurse : nurses) {

            if (nurse.getAge() > age) {
                nurseList.add(nurse);
            }
        }
        return nurseList;
    }

    public List<Nurse> getNurseByQualification(String qualification) {

        List<Nurse> nurseList = new ArrayList<>();

        List<Nurse> nurses = nurseRepository.getAll();

        for (Nurse nurse : nurses) {

            if (nurse.getQualification().equals(qualification)) {
                nurseList.add(nurse);
            }
        }
        return nurseList;
    }

    public String updateNurse(Nurse nurse) {

        String message = nurseRepository.updateNurse(nurse);
        return message;
    }

    public String updateNurseQualification(Integer nurseId, String qualification) {

        Nurse nurse = nurseRepository.getNurse(nurseId);

        if (nurse.equals(null) == false) {

            // update nurse qualification
            nurse.setQualification(qualification);

            String message = updateNurse(nurse);
            return "nurse qualification updated";
        }
        else {
            return "nurse not found";
        }
    }
}
