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
        return "nurse added via body";
    }

    public List<Nurse> getAll() {

        return nurseHashMap.values().stream().toList();
    }
}
