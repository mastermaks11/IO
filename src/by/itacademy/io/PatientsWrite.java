package by.itacademy.io;

import by.itacademy.io.Hospital;
import by.itacademy.io.Patient;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/**
 * Created by user on 23.06.2018.
 */
public class PatientsWrite {
    private Hospital hospital;

    public PatientsWrite(Hospital hospital) {
        this.hospital = hospital;
    }

    public void write(String fileName) throws IOException {
        Set<Patient> patients = hospital.getPatients();
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(fileName)))) {
            for (Patient patient : patients) {
                out.writeUTF(patient.getName());
                out.writeUTF(patient.getSurname());
                out.writeLong(patient.getBirth().getTime());
                out.writeBoolean(patient.isHealth());
            }

        }
    }
}
