package com.example.usermicroservice.config;

import com.example.usermicroservice.vo.RequestLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            RequestLogin creds = new ObjectMapper()
                .readValue(request.getInputStream(), RequestLogin.class); // post로 넘어오는 body를 inputstream으로 읽을 수 있다.

            return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(
                        creds.getEmail(),
                        creds.getPassword(),
                        new ArrayList<>()
                    )
                );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 인증이 성공된 이후
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
        throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
