package by.itacademy.io;

import by.itacademy.io.Hospital;
import by.itacademy.io.Patient;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

/**
 * Created by user on 23.06.2018.
 */
public class PatientUploadLocalFile {
    private Hospital hospital;
    private String nameFile;

    public PatientUploadLocalFile(Hospital hospital, String nameFile) {
        this.hospital = hospital;
        this.nameFile = nameFile;
    }

    public void uploadLocalFile() throws IOException, ParseException {
        Set<Patient> patients = hospital.getPatients();
        DataInputStream input = new DataInputStream(new FileInputStream(new File(nameFile)));
        while (input.available() > 0) {
            Patient patient = new Patient(input.readUTF(), input.readUTF(), new Date(input.readLong()), input.readBoolean());
            hospital.add(patient);
        }

    }
}

