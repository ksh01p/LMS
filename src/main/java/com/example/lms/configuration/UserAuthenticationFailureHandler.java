package com.example.lms.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


import java.io.IOException;

public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg = "로그인에 실패하였습니다.";

        // 예외 메시지 커스터마이징
        if (exception instanceof InternalAuthenticationServiceException) {
            msg = exception.getMessage();
        }

        // 포워딩 방식 설정
        setUseForward(true);
        setDefaultFailureUrl("/member/login?error=true");

        // 요청 속성에 에러 메시지 추가
        request.setAttribute("errorMessage", msg);

        System.out.println("로그인 실패: " + msg);

        // 부모 클래스의 메서드 호출 (포워딩 처리)
        super.onAuthenticationFailure(request, response, exception);
    }

}
