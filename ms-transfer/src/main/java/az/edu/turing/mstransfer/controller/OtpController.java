package az.edu.turing.mstransfer.controller;

import az.edu.turing.mstransfer.service.AuthService;
import az.edu.turing.mstransfer.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OtpController {
    private final AuthService authService;
    private final OtpService otpService;

    @PostMapping("/otp")
    public Boolean otpSender(@RequestHeader String auth , @RequestParam Integer otp) {
        String fin = authService.getFinCodeFromAuth(auth);
        return otpService.validateOtp(fin, otp);

    }
}
