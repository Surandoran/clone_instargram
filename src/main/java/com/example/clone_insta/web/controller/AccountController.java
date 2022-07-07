package com.example.clone_insta.web.controller;

import com.example.clone_insta.domain.user.UserLoginDto;
import com.example.clone_insta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AccountController {

    public final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public String signup(UserLoginDto userLoginDto) {
        if(userService.save(userLoginDto)) {
            return "redirect:/login";
        }else {
            return "redirect:/signup?error";
        }
    }

}
