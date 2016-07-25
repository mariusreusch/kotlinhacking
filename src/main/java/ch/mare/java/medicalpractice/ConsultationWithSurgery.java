package ch.mare.java.medicalpractice;

import java.time.LocalDate;

public class ConsultationWithSurgery extends Consultation {
    public ConsultationWithSurgery(LocalDate date, double expenses, String shortDescription, boolean paid) {
        super(date, expenses, shortDescription, paid);
    }

    public String getSurgeryDetail(){
        return "A quite difficult surgery";
    }

}
