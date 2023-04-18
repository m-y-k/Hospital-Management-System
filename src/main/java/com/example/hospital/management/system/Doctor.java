package com.example.hospital.management.system;

import java.util.SimpleTimeZone;

public class Doctor {
    private int doctorId;
    private String name;
    private String qualification;
    private String specialization;
    private int age;

    public Doctor(int doctorId, String name, String qualification, String specialization, int age) {
        this.doctorId = doctorId;
        this.name = name;
        this.qualification = qualification;
        this.specialization = specialization;
        this.age = age;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
