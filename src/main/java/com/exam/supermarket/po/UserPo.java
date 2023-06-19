package com.exam.supermarket.po;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserPo implements Serializable {
    private static final long serialVersionUID = 7047248151112708757L;

    @ExcelProperty("用户id")
    private String id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("昵称")
    private String name;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("角色")
    private String role;

    @ExcelProperty("vip卡号")
    private String vip;
}
