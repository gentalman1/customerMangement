package com.psp.example;

import java.util.Base64;

public class Example {

    public static void main(String[] args) {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("originalInput::{}\n\n" + encodedString);

        System.out.println("originalInput::{}\n\n" + new String(Base64.getDecoder().decode("UHVydmE0MzRA")));
    }
}
