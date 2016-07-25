package ch.mare.java.nullchecks;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MailSender {

    public void sendMessageToClient(@Nullable Client client, @Nullable String message, @NotNull Mailer mailer) {
        if (client == null || message == null) {
            return;
        }

        PersonalInfo personalInfo = client.getPersonalInfo();
        if (personalInfo == null) {
            return;
        }

        String email = personalInfo.getEmail();
        if (email == null) {
            return;
        }

        mailer.sendMessage(email, message);
    }

}

class Client {

    public PersonalInfo getPersonalInfo() {
        return null;
    }
}

class Mailer {

    public void sendMessage(String email, String message) {
        System.out.println("send message " + message + " to " + email);
    }
}

class PersonalInfo {

    public String getEmail() {
        return null;
    }
}