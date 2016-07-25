import ch.mare.java.Consultation
import ch.mare.java.ConsultationWithSurgery
import ch.mare.java.Gender
import ch.mare.kotlin.Patient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class PatientTest {

    @Test
    fun patientWithNoConsultations_getLastConsultation_null() {
        val peterchen = Patient(insurancePolicyNumber = "1337",
                firstName = "Peterchen",
                lastName = "Peterson",
                birthDate = LocalDate.of(1961, Month.JANUARY, 1),
                gender = Gender.MALE,
                bloodType = "B", sizeInCentimeter = 160.0, weightInKilogram = 100.0)

        val lastConsultation = peterchen.getLastConsultation()

        assertNull(lastConsultation)
    }

    @Test
    fun patientWithThreeConsultations_getLastConsultation_foundLastConsultation() {
        val patient = createPatientWithConsultations()

        val lastConsultation = patient.getLastConsultation()

        assertEquals(LocalDate.of(2016, Month.JULY, 18), lastConsultation?.date)
    }



    private fun createPatientWithConsultations(): Patient {
        val consultations = listOf(Consultation(LocalDate.of(2016, Month.MAY, 12), 100.00, "", true),
                Consultation(LocalDate.of(2016, Month.JUNE, 21), 500.00, "Dental cleaning", true),
                Consultation(LocalDate.of(2016, Month.JULY, 18), 1000.00, "Remove caries", false))
        val kunibert = Patient(insurancePolicyNumber = "4321",
                firstName = "Kuni",
                lastName = "Bert",
                birthDate = LocalDate.of(1975, Month.DECEMBER, 12),
                gender = Gender.MALE,
                bloodType = "A positiv",
                sizeInCentimeter = 180.0, weightInKilogram = 90.0, consultations = consultations)
        return kunibert
    }


}
