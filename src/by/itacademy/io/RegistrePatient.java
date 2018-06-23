package by.itacademy.io;

import by.itacademy.io.Hospital;
import by.itacademy.io.Patient;
import by.itacademy.io.PatientsUpload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 23.06.2018.
 */
public class RegistrePatient {
    private Scanner scan = new Scanner(System.in);
    private Hospital hospital;
    private String source = "https://raw.githubusercontent.com/mastermaks11/file/master/by.itacademy.io.Hospital.txt";

    public RegistrePatient() throws MalformedURLException {
        this.hospital = new Hospital();

    }
    public void registre() throws ParseException, IOException {
        Secretary secretary = new Secretary("patients.dat", hospital);
        try {
            secretary.readFile();
            System.out.println(hospital);
            System.out.println("Load Patients in LocalFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите кол-во пацентов");
        int count = scan.nextInt();
        while( count!= 0)
        {
            hospital.add(new Patient(scan.next(), scan.next(), new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(scan.next()), scan.nextBoolean()));
            count = count - 1;
        }
        PatientsUpload patientsUpload = new PatientsUpload(source , hospital);
        patientsUpload.upload();
        try {
            secretary.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            secretary.write();
            secretary.remoteAdd();
            secretary.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hospital);
    }
}

