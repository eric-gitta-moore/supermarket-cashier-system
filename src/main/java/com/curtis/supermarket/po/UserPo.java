package com.curtis.supermarket.po;

import lombok.Data;

@Data
public class UserPo {
    String id;
    String username;
    String password;
    String role;
    String vip;
}
