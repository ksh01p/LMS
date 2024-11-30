package com.example.lms.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import javax.mail.internet.MimeMessage;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class MailComponents {

    private final JavaMailSender javaMailSender;

    // 간단한 텍스트 이메일 전송
    public void sendMailTest() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("william7872ksh@naver.com");
        msg.setSubject("안녕하세요 KSH입니다.");
        msg.setText("Hello I'm KSH ");

        try {
            javaMailSender.send(msg);
            System.out.println("테스트 이메일 전송 성공");
        } catch (Exception e) {
            System.err.println("테스트 이메일 전송 실패: " + e.getMessage());
        }
    }

    // HTML 이메일 전송
    public boolean sendMail(String mail, String subject, String text) {
        if (!isValidEmail(mail)) {
            System.err.println("유효하지 않은 이메일 주소: " + mail);
            return false;
        }

        boolean result = false;

        MimeMessagePreparator msg = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(mail);
            helper.setSubject(subject);
            helper.setText(text, true); // HTML 지원
            System.out.println("이메일 준비 완료 - To: " + mail + ", Subject: " + subject);
        };

        try {
            javaMailSender.send(msg);
            result = true;
            System.out.println("이메일 전송 성공: " + mail);
        } catch (Exception e) {
            System.err.println("이메일 전송 실패: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    // 이메일 주소 유효성 검사
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
}
