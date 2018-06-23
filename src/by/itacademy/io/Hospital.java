package by.itacademy.io;

import java.util.HashSet;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>();

    public void add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "by.itacademy.io.Hospital{" + "patients=" + patients + '}';
    }
}