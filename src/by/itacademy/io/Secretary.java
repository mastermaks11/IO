package by.itacademy.io;

import by.itacademy.io.Hospital;
import by.itacademy.io.PatientUploadLocalFile;
import by.itacademy.io.PatientsUpload;
import by.itacademy.io.PatientsWrite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class Secretary {
    private Hospital hospital;
    private String fileName;
    private PatientsUpload upload;
    private PatientsWrite write;
    private PatientUploadLocalFile readLocalFile;

    public Secretary(String fileName, Hospital hospital) throws MalformedURLException {
        this.fileName = fileName;
        this.hospital = hospital;
        upload = new PatientsUpload("https://raw.githubusercontent.com/mastermaks11/file/master/by.itacademy.io.Hospital.txt", hospital);
        write = new PatientsWrite(hospital);
        readLocalFile = new PatientUploadLocalFile(hospital, fileName);
    }

    public void remoteAdd() throws IOException, ParseException {
        upload.upload();
    }


    public void write() throws IOException {
        write.write(fileName);
    }
    public void readFile() throws IOException, ParseException {
        readLocalFile.uploadLocalFile();
    }
}