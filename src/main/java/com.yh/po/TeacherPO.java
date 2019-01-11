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

    /**
     * 教师名称
     */
    @NotNull
    private String teaName;

    /**
     * 生日
     */
    @NotNull
    private Date birth;

    /**
     * 性别
     */
    @NotNull
    private char sex;

    /**
     * 详情
     */
    @NotNull
    private String detail;
}
