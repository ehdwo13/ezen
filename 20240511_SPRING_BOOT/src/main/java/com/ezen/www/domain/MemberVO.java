package com.ezen.www.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class MemberVO {
    private String email;
    private String password;
    private String nickName;
    private String regAt;
    private String lastLogin;
    private List<AuthVO> authList;
}
