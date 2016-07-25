package ch.mare.kotlin.medicalpractice

import ch.mare.java.medicalpractice.Consultation
import ch.mare.java.medicalpractice.Gender.MALE
import java.time.LocalDate
import java.time.Month

fun main(args: Array<String>) {
    val consultations = listOf(Consultation(LocalDate.of(2016, Month.MAY, 12), 100.00, "", true),
            Consultation(LocalDate.of(2016, Month.JUNE, 21), 500.00, "Dental cleaning", true),
            Consultation(LocalDate.of(2016, Month.JULY, 18), 1000.00, "Remove caries", false))

    val patient = Patient(insurancePolicyNumber = "4321",
            firstName = "Kuni",
            lastName = "Bert",
            birthDate = LocalDate.of(1975, Month.DECEMBER, 12),
            gender = MALE,
            bloodType = "A positiv",
            sizeInCentimeter = 180.0, weightInKilogram = 90.0, consultations = consultations)

    val patient1 = Patient(insurancePolicyNumber = "1337",
            firstName = "Peterchen",
            lastName = "Peterson",
            birthDate = LocalDate.of(1961, Month.JANUARY, 1),
            gender = MALE,
            bloodType = "B", sizeInCentimeter = 160.0, weightInKilogram = 100.0)

    val patient2 = Patient("8181", "Volker", "Putt", LocalDate.of(1969, Month.JUNE, 21), MALE, "A", 170.0, 50.0)

}
