package com.example.hospital.management.system.repositories;

import com.example.hospital.management.system.models.Nurse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {

    HashMap<Integer, Nurse> nurseHashMap = new HashMap<>();

    public String addNurse(Nurse nurse) {

        int key = nurse.getNurseId();

        nurseHashMap.put(key, nurse);
        return "nurse added";
    }

    public Nurse getNurse(Integer nurseId) {

        if (nurseHashMap.containsKey(nurseId)) {

            return nurseHashMap.get(nurseId);
        }
        else {
            return null;
        }
    }

    public List<Nurse> getAll() {

        return nurseHashMap.values().stream().toList();
    }

    public String updateNurse(Nurse nurse) {

        int key = nurse.getNurseId();

        if (nurseHashMap.containsKey(key)) {

            nurseHashMap.put(key, nurse);
            return "nurse updated";
        }
        else {
            return "record not found";
        }
    }

    public String updateNurseName(Integer nurseId, String name) {

        Nurse nurse = nurseHashMap.get(nurseId);

        nurse.setName(name);

        nurseHashMap.put(nurseId, nurse);

        return "nurse name updated successfully";
    }

    public String deleteNurse(Integer nurseId) {

        if (nurseHashMap.containsKey(nurseId)) {
            nurseHashMap.remove(nurseId);
            return "nurse has been deleted";
        }
        else {
            return "nurse not found";
        }
    }

    public String deleteNurseByAge(Integer age) {

        for (Integer key : nurseHashMap.keySet()) {

            Nurse nurse = nurseHashMap.get(key);

            if (nurse.getAge() == age) {
                nurseHashMap.remove(key);
            }
        }
        return "successfully deleted nurse of age - " + age;
    }

}
