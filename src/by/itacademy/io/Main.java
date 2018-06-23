package by.itacademy.io;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        RegistrePatient registrePatient = new RegistrePatient();
        try {
            System.setProperty("java.until.logging.config.file","logger.properties");
            LogManager.getLogManager().readConfiguration();

        }
        catch (IOException e)
        {
            System.err.println(e.toString());
        }

        registrePatient.registre();

    }
}
