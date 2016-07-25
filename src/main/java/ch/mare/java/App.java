package ch.mare.java;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static ch.mare.java.Gender.MALE;

public class App {
    public static void main(String[] args) {

        ArrayList<Consultation> consultations = new ArrayList<>();

        consultations.add(new Consultation(LocalDate.of(2016, Month.MAY, 12), 100.00, "", true));
        consultations.add(new Consultation(LocalDate.of(2016, Month.JUNE, 21), 500.00, "Dental cleaning", true));
        consultations.add(new Consultation(LocalDate.of(2016, Month.JULY, 18), 1000.00, "Remove caries", false));

        new Patient("4321", "Kuni", "Bert", LocalDate.of(1975, Month.DECEMBER, 12), MALE, "A", 180, 90, consultations);
        new Patient("1337", "Peterchen", "Peterson", LocalDate.of(1975, Month.DECEMBER, 12), MALE, null, 160, 100);
    }
}
