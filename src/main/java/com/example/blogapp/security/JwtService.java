package com.example.blogapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  public static final String SECRET = "sdjfjshro2h3ewbef83hre3ir238hf132h3r239e23f23";
  Algorithm algorithm = Algorithm.HMAC256(SECRET);

  public String createJwt(String username) {
    if (username == null) {
      throw new IllegalArgumentException("Cannot create token without username");
    }
    return JWT.create()
        .withSubject(username)
        .withIssuedAt(new Date())
        .sign(algorithm);
  }

  public String getUsernameFromJwt(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }
}
