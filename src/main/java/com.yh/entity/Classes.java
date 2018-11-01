package com.yh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Classes implements Serializable{

    private static final long serialVersionUID = 6797131259803190638L;

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
