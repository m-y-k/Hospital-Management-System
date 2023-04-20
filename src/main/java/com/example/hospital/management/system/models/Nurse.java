package com.example.hospital.management.system.models;

public class Nurse {
    private int nurseId;
    private String name;
    private String qualification;
    private int age;

    public Nurse(int nurseId, String name, String qualification, int age) {
        this.nurseId = nurseId;
        this.name = name;
        this.qualification = qualification;
        this.age = age;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
