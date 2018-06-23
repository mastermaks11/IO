package by.itacademy.io;

import by.itacademy.io.Hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

public class PatientsUpload {
    private URL source;
    private Hospital hospital;

    public PatientsUpload(String source, Hospital hospital) throws MalformedURLException {
        this.hospital = hospital;
        this.source = new URL(source);
    }

    public void upload() throws IOException, ParseException {
        URLConnection connection = source.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toString());
                Patient patient = new Patient(line);
                hospital.add(patient);
            }
        }
    }
}