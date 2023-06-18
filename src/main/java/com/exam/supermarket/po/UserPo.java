package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPo implements Serializable {
    private static final long serialVersionUID = 7047248151112708757L;
    private String id;
    private String username;
    private String name;
    private String password;
    private String role;
    private String vip;
}
