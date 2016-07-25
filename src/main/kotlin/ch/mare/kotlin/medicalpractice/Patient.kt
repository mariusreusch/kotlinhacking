package ch.mare.kotlin.medicalpractice

import ch.mare.java.medicalpractice.Consultation
import ch.mare.java.medicalpractice.Gender
import java.time.LocalDate

data class Patient(val insurancePolicyNumber: String, val firstName: String, val lastName: String,
                   val birthDate: LocalDate, var gender: Gender = Gender.FEMALE, val bloodType: String,
                   var sizeInCentimeter: Double, var weightInKilogram: Double, var consultations: List<Consultation> = mutableListOf()) {

    fun calcTotalAmount() = consultations.sumByDouble { it.expenses }

    fun calcTotalAmountOfUnpaidConsultations(): Double {
        return consultations.filter { !it.isPaid }
                .sumByDouble { it.expenses }
    }

    fun getLastConsultation(): Consultation? = consultations.maxBy { it.date }
}
