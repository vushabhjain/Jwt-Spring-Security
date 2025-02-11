package com.voting.Service;

import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {
    private final ConcurrentHashMap<String, String> otpStorage = new ConcurrentHashMap<>();

    // Generate and store OTP
    public String generateOtp(String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000)); // 6-digit OTP
        otpStorage.put(email, otp);
        return otp;
    }

    // Validate OTP
    public boolean validateOtp(String email, String otp) {
        return otpStorage.containsKey(email) && otpStorage.get(email).equals(otp);
    }

    // Remove OTP after verification
    public void removeOtp(String email) {
        otpStorage.remove(email);
    }
}
