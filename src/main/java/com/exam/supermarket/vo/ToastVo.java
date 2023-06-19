package com.exam.supermarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToastVo {

    private String type = "info";
    private String title;
    private String msg;

    private String tipsTime;

    public ToastVo(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }
}
