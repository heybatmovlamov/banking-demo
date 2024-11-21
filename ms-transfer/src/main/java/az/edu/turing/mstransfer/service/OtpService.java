package az.edu.turing.mstransfer.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.random.RandomGenerator;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OtpService {
    private final NotificationService notificationService;
    private final RabbitTemplate rabbitTemplate;
    private final RandomGenerator randomGenerator = new Random();
    private final Map<String, Integer> otpStorage = new HashMap<>();

    public Integer  otpGenerator(String fin) {
        Integer otp = 1000 + randomGenerator.nextInt(9000);
        otpStorage.put(fin, otp);
        return otp;
    }

    public Integer generateAndSendOtp(String fin) {
        Integer otp = otpGenerator(fin);
        sendOtpEmail(fin, otp);
        return otp;
    }
    public void sendOtpToQueue(String otp) {
        rabbitTemplate.convertAndSend("otpQueue", otp);
    }

    public boolean validateOtp(String finCode, Integer inputOtp) {
        return otpStorage.containsKey(finCode) && otpStorage.get(finCode).equals(inputOtp);
    }
    private void sendOtpEmail(String email, Integer otp) {
       notificationService.sendEmail(email,"OTP",otp);
    }
}