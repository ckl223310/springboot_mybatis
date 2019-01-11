package com.yh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 课程类
 */
@Getter
@Setter
@ToString
public class Classes implements Serializable {

    private static final long serialVersionUID = 6797131259803190638L;

    /**
     * 课程ID
     */
    @NotNull
    private String classId;

    /**
     * 学生Id
     */
    @NotNull
    private String stuId;

    /**
     * 教师Id
     */
    @NotNull
    private String teaId;

    /**
     * 班级姓名
     */
    @NotNull
    private String className;

    /**
     * 课时
     */
    private int hours;

    /**
     * 详情
     */
    private String detail;
}
