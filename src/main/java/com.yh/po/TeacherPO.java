package com.yh.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * po 类 前台向后台传输的参数（一般称为VO类）
 */
@Setter
@Getter
@ToString
public class TeacherPO {

    @NotNull
    private String teaName;

    @NotNull
    private Date birth;

    @NotNull
    private char sex;

    @NotNull
    private String detail;
}
