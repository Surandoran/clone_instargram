package com.example.clone_insta.domain.user;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    private String email;
    private String password;
    private String phone;
    private String name;

}
