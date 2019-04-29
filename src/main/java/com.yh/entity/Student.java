package com.yh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体类
 * student 表
 */
@Getter
@Setter
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 4178584042150319421L;

    /**
     * 学号
     */
    private String stuId;

    /**
     * 姓名
     */
    private String stuName;

    public Student() {
    }

    public Student(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth;

    /**
     * 性别（男或女）
     */
    private char sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 地址
     */
    private String addr;

    /**
     * 其他详情
     */
    private String detail;
}
