package com.voting.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil1 {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    // Use the secret key in methods
}
