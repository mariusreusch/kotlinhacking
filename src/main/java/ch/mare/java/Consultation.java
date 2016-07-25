package ch.mare.java;

import java.time.LocalDate;

public class Consultation {
    private LocalDate date;
    private double expenses;
    private String shortDescription;
    private boolean paid;

    public Consultation(LocalDate date, double expenses, String shortDescription, boolean paid) {
        this.date = date;
        this.expenses = expenses;
        this.shortDescription = shortDescription;
        this.paid = paid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
