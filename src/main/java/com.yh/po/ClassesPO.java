package com.yh.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 课程PO
 */
@Getter
@Setter
@ToString
public class ClassesPO {

    /**
     * 课程ID
     */
    @NotNull
    private String classId;

    /**
     * 学生ID
     */
    @NotNull
    private String stuId;

    /**
     * 教师ID
     */
    @NotNull
    private String teaId;

    /**
     * 课程名称
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
