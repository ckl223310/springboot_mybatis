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
public class Teacher implements Serializable {


    /**
     * 工号
     */
    private String teaId;

    /**
     * 姓名
     */
    private String teaName;

    /**
     * 性别（男或女）
     */
    private char sex;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth;

    /**
     * 其他详情
     */
    private String detail;
}