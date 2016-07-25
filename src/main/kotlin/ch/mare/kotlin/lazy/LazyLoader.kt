package ch.mare.kotlin.lazy

fun main(args: Array<String>) {
    val emailAccount = EmailAccount()
    println(emailAccount.emails)
    println(emailAccount.emails)
}


class EmailAccount {

    val emails: List<String> by lazy { loadEmail() }

    private fun loadEmail():List<String>{
        println("... load Emails ...")
        Thread.sleep(5000)
        println("Emails loaded")
        return listOf("Email1", "Email2", "Email3")
    }
}