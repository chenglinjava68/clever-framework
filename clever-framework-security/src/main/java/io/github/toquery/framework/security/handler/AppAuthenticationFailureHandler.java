package io.github.toquery.framework.security.handler;

import io.github.toquery.framework.common.util.JacksonUtils;
import io.github.toquery.framework.webmvc.domain.ResponseParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");

        if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
            ResponseParam responseParam = ResponseParam.builder().message("用户信息错误").build();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, JacksonUtils.object2String(responseParam));
        }
    }
}
