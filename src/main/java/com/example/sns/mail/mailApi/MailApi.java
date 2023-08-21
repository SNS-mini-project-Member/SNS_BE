package com.example.sns.mail.mailApi;

import com.example.sns.mail.mailService.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailApi {
    // 이메일 인증
    private final MailService mailService;

    @PostMapping("/{email}")
    public String mailConfirm(@PathVariable String email) throws Exception{
        return mailService.sendSimpleMessage(email);
    }
}