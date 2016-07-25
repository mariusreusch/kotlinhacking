package ch.mare.kotlin.nullchecks

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }

//    if(message != null){
//        client?.personalInfo?.email?.let { mailer.sendMessage(it, message) }
//    }
}

class Client {

    val personalInfo: PersonalInfo?
        get() = null
}

class Mailer {

    fun sendMessage(email: String, message: String) {
        println("send message $message to $email")
    }
}

class PersonalInfo {

    val email: String?
        get() = null
}