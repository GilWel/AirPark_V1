package com.example.airpark.service.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        // Генерация случайного 256-битного ключа (32 байта)
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32];  // 256 битный ключ
        secureRandom.nextBytes(key);

        // Кодирование ключа в Base64 для использования в приложении
        String secretKey = Base64.getEncoder().encodeToString(key);

        // Выводим ключ в консоль
        System.out.println("Generated Secret Key: " + secretKey);
    }
}
