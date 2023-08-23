package com.example.sns.mail.mailApi;

import com.example.sns.domain.request.EmailRequest;
import com.example.sns.mail.mailService.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MailApi {

    private final MailService mailService;

    // 회원가입 시 이메일 인증
    @PostMapping
    public String mailConfirm(@RequestBody EmailRequest email) throws Exception{
        System.out.println(email);
        return mailService.sendSimpleMessage(email);
    }

//     비밀번호 변경 시 이메일로 임시비밀번호 발급
    @PostMapping("/pwChange")
    public String pwMailConfirm(@RequestBody EmailRequest email) throws Exception{
        System.out.println("들어왔다.");
        return mailService.sendSimpleMessage2(email);
    }
    
}