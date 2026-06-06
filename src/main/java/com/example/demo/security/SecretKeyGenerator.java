package com.example.demo.security;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.SecretKey;

public class SecretKeyGenerator {

    public static void main(String[] args) {

        SecretKey key = Keys.secretKeyFor(
                io.jsonwebtoken.SignatureAlgorithm.HS256);

        String secretString =
                Encoders.BASE64.encode(key.getEncoded());

        System.out.println(secretString);
    }
}