package chatting.chatting.login.controller;

import chatting.chatting.login.domain.LoginForm;
import chatting.chatting.login.service.LoginService;
import chatting.chatting.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    public String login(LoginForm form, BindingResult bindingResult, HttpServletRequest request) {

        HttpSession session = request.getSession();

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        } else {
            log.info("로그인ID ::: " + loginMember.getMemberId());
            log.info("로그인NM ::: " + loginMember.getMemberNm());
            session.setAttribute("loginId", loginMember.getMemberId());
            session.setAttribute("loginNm", loginMember.getMemberNm());
        }

        //로그인 성공처리 TODO

        return "comm/main";
    }
}
