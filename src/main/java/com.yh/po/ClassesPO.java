package com.yh.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

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
