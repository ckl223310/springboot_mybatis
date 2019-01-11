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
public class StudentPO {

    /**
     * 学生姓名
     */
    @NotNull
    private String stuName;

    /**
     * 学生日期
     */
    @NotNull
    private Date birth;

    /**
     * 学生性别
     */
    @NotNull
    private char sex;

    /**
     * 电话
     */
    @NotNull
    private String phone;

    /**
     * 地址
     */
    @NotNull
    private String addr;

    /**
     * 详情
     */
    @NotNull
    private String detail;
}
