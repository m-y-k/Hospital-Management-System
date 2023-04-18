package com.example.hospital.management.system;

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
}
