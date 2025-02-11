package com.voting.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voting.Entity.User;
import com.voting.Repository.UserRepository;
import com.voting.Service.EmailService;
import com.voting.Service.JwtUtil;
import com.voting.Service.OtpService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final OtpService otpService;
    private final EmailService emailService;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, OtpService otpService, EmailService emailService, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.otpService = otpService;
        this.emailService = emailService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/request-otp")
    public ResponseEntity<String> requestOtp(@RequestParam String email) {
        email = email.trim(); // Remove any accidental spaces

        Optional<User> user = userRepository.findByEmailId(email);
        if (user.isPresent()) {
            String otp = otpService.generateOtp(email);
            emailService.sendOtpEmail(email, otp);
            return ResponseEntity.ok("OTP sent to " + email);
        }
        return ResponseEntity.badRequest().body("Email not registered!");
    }



    // Verify OTP and Login
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        if (otpService.validateOtp(email, otp)) {
            otpService.removeOtp(email);
            String token = jwtUtil.generateToken(email);
            return ResponseEntity.ok("Login Successful! JWT Token: " + token);
        }
        return ResponseEntity.badRequest().body("Invalid OTP!");
    }
}
