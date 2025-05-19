package com.example.airpark.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    // Секретный ключ для подписи JWT, который будет загружаться из application.properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    // Срок жизни токена (1 день)
    @Value("${jwt.expiration}")
    private int jwtExpirationMs = 86400000;

    // Генерация JWT токена
    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Устанавливаем имя пользователя в токен
                .setIssuedAt(new Date())  // Время создания токена
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))  // Время истечения токена
                .signWith(SignatureAlgorithm.HS512, jwtSecret)  // Подписываем токен секретным ключом
                .compact();
    }

    // Извлечение имени пользователя из JWT токена
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)  // Для проверки подписи используем секретный ключ
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Проверка валидности JWT токена
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);  // Проверяем подпись
            return true;
        } catch (Exception e) {
            return false;  // В случае ошибки возвращаем false
        }
    }
}
