package com.example.sns.mail.mailApi;

import com.example.sns.mail.mailService.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MailApi {
    // 이메일 인증
    private final MailService mailService;

    @PostMapping("/{email}")
    public String mailConfirm(@PathVariable String email) throws Exception{
        return mailService.sendSimpleMessage(email);
    }
}