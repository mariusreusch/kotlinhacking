package ch.mare.java.medicalpractice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    private final String insurancePolicyNumber;
    private final String firstName;
    private final String lastName;
    private final String bloodType;
    private final LocalDate birthDate;
    private double sizeInCentimeter;
    private double weightInKilogram;
    private Gender gender;
    private List<Consultation> consultations;

    public Patient(String insurancePolicyNumber, String firstName, String lastName, LocalDate birthDate, String bloodType, double sizeInCentimeter, double weightInKilogram) {
        this(insurancePolicyNumber, firstName, lastName, birthDate, bloodType, sizeInCentimeter, weightInKilogram, new ArrayList<>());
    }

    public Patient(String insurancePolicyNumber, String firstName, String lastName, LocalDate birthDate, String bloodType, double sizeInCentimeter, double weightInKilogram, List<Consultation> consultations) {
        this(insurancePolicyNumber, firstName, lastName, birthDate, Gender.FEMALE, bloodType, sizeInCentimeter, weightInKilogram, consultations);
    }

    public Patient(String insurancePolicyNumber, String firstName, String lastName, LocalDate birthDate, Gender gender, String bloodType, double sizeInCentimeter, double weightInKilogram) {
        this(insurancePolicyNumber, firstName, lastName, birthDate, gender, bloodType, sizeInCentimeter, weightInKilogram, new ArrayList<>());
    }

    public Patient(String insurancePolicyNumber, String firstName, String lastName, LocalDate birthDate, Gender gender, String bloodType, double sizeInCentimeter, double weightInKilogram, List<Consultation> consultations) {
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.bloodType = bloodType;
        this.sizeInCentimeter = sizeInCentimeter;
        this.weightInKilogram = weightInKilogram;
        this.consultations = consultations;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSizeInCentimeter() {
        return sizeInCentimeter;
    }

    public void setSizeInCentimeter(double sizeInCentimeter) {
        this.sizeInCentimeter = sizeInCentimeter;
    }

    public double getWeightInKilogram() {
        return weightInKilogram;
    }

    public void setWeightInKilogram(double weightInKilogram) {
        this.weightInKilogram = weightInKilogram;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(insurancePolicyNumber, patient.insurancePolicyNumber) &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(bloodType, patient.bloodType) &&
                Objects.equals(birthDate, patient.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insurancePolicyNumber, firstName, lastName, bloodType, birthDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Consultation getLastConsultation() {
        Consultation latestConsultation = null;
        for (Consultation consultation : consultations) {
            if (latestConsultation == null) {
                latestConsultation = consultation;
            } else {
                if(consultation.getDate().isAfter(latestConsultation.getDate())){
                    latestConsultation = consultation;
                }
            }
        }
        return latestConsultation;

        /*List<Consultation> sortedConsultations = consultations.stream()
                .sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate()))
                .collect(Collectors.toList());
        Collections.reverse(sortedConsultations);
        if (sortedConsultations.isEmpty()) {
            return null;
        }
        return sortedConsultations.get(0);*/
    }

    public double calcTotalAmount() {
        return consultations.stream()
                .mapToDouble(Consultation::getExpenses)
                .sum();
    }

    public double calcTotalAmountOfUnpaidConsultations() {
        return consultations.stream()
                .filter(consultation -> !consultation.isPaid())
                .mapToDouble(Consultation::getExpenses)
                .sum();
    }


    // TODO: 22/07/16 Methode mit return null

    // TODO: 22/07/16 hier zum Vergleich noch eine pre Java 8 Stream/Lambda Methode und dann auch Bezug auf Android
    /*public double calcTotalAmountOfUnpaidConsultationsBeForeJava8(){
        double amount = 0.0;
        for (Consultation consultation : consultations) {
            if(!consultation.isPaid()){
                amount += consultation.getExpenses();
            }
        }
        return amount;
    }*/
}
