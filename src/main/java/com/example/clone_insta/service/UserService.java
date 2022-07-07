package com.example.clone_insta.service;

import com.example.clone_insta.domain.user.User;
import com.example.clone_insta.domain.user.UserLoginDto;
import com.example.clone_insta.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    /*
    * 회원정보 추가
    * @param userLoginDto 회원 가입 폼으로 부터 전달받은 정보
    * @return 이미 저장된 email 여부에 따라 사용자 추가가 되었는지에 대한 boolean 값.
     */

    @Transactional
    public boolean save(UserLoginDto userLoginDto) {
        if(userRepository.findUserByEmail(userLoginDto.getEmail()) != null) return false;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userRepository.save(User.builder()
                .email(userLoginDto.getEmail())
                .password(encoder.encode(userLoginDto.getPassword()))
                .phone(userLoginDto.getPhone())
                .name(userLoginDto.getName())
                .title(null)
                .website(null)
                .profileImgUrl("/img/default_profile.jpg")
                .build());
        return true;
    }
}
