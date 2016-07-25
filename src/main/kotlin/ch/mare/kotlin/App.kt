package ch.mare.kotlin

import ch.mare.java.Consultation
import ch.mare.java.ConsultationWithSurgery
import ch.mare.java.Gender.MALE
import java.time.LocalDate
import java.time.Month

fun main(args: Array<String>) {
    val consultations = listOf(Consultation(LocalDate.of(2016, Month.MAY, 12), 100.00, "", true),
            Consultation(LocalDate.of(2016, Month.JUNE, 21), 500.00, "Dental cleaning", true),
            Consultation(LocalDate.of(2016, Month.JULY, 18), 1000.00, "Remove caries", false))

    val first = consultations.first()

    if (first is ConsultationWithSurgery) {
        val sc = first.surgeryDetail
    }

    Patient(insurancePolicyNumber = "4321",
            firstName = "Kuni",
            lastName = "Bert",
            birthDate = LocalDate.of(1975, Month.DECEMBER, 12),
            gender = MALE,
            bloodType = "A positiv",
            sizeInCentimeter = 180.0, weightInKilogram = 90.0, consultations = consultations)

    val peterchen = Patient(insurancePolicyNumber = "1337",
            firstName = "Peterchen",
            lastName = "Peterson",
            birthDate = LocalDate.of(1961, Month.JANUARY, 1),
            gender = MALE,
            bloodType = "B", sizeInCentimeter = 160.0, weightInKilogram = 100.0)

}




//listOf
//Als Erleichterung zur Konvertierung bietet IDEA mehrere Werkzeuge: File Converter, Copy Java Code To Kotlin file
//null reingeben
//Keine class definition
