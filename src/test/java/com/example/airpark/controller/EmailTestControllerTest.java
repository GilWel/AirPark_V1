package com.example.airpark.controller;
import com.example.airpark.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(EmailTestController.class)
public class EmailTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmailService emailService;

    @Test
    void testSendEmail() throws Exception {
        // Установим мок для отправки email
        doNothing().when(emailService).sendSimpleEmail(anyString(), anyString(), anyString());

        // Отправляем POST-запрос и проверяем статус
        mockMvc.perform(post("/api/email/send")
                        .param("to", "test@example.com")
                        .param("subject", "Test Subject")
                        .param("text", "Test body"))
                .andExpect(status().isOk())
                .andExpect(content().string("Email send to test@example.com"));

        // Проверяем, что метод sendSimpleEmail был вызван
        verify(emailService).sendSimpleEmail("test@example.com", "Test Subject", "Test body");
    }
}