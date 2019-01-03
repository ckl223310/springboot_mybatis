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

    @NotNull
    private String classId;

    @NotNull
    private String stuId;

    @NotNull
    private String teaId;

    @NotNull
    private String className;

    private int hours;

    private String detail;
}
