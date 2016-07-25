package ch.mare.kotlin

import ch.mare.java.Consultation
import ch.mare.java.Gender
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


// data class /
// hashcode ist diskussionswürdig
// val / var
// default constructor
// Java 6
// Better Streaming API see sumBy
// function with equal sign
//getLastConsultation1 without sort descending zeigen
/*
fun getLastConsultation1(): Consultation? {
    val sortedConsultations = consultations.sortedBy { it.date }
    Collections.reverse(sortedConsultations)
    return if(sortedConsultations.isEmpty()){
        null
    } else {
        sortedConsultations.get(0)
    }

}*/
/*
override fun equals(other: Any?): Boolean {
    if (other !is Patient)
        return false

    return firstName == other.firstName &&
            birthDate == other.birthDate
}

override fun hashCode(): Int {
    return Objects.hash(firstName, birthDate)

}*/
