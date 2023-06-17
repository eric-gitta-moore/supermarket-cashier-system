package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPo implements Serializable {
    private static final long serialVersionUID = 7047248151112708757L;
    String id;
    String username;
    String password;
    String role;
    String vip;
}
