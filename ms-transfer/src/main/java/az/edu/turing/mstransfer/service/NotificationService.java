package az.edu.turing.mstransfer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMailId;

    public void sendEmail(String to, String subject, Integer body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(String.valueOf(body));
        message.setFrom(fromMailId);

        mailSender.send(message);
    }
}
