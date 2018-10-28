package com.yh.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
public class StudentPO {

    @NotNull
    private String stuName;

    @NotNull
    private Date birth;

    @NotNull
    private char sex;

    @NotNull
    private String phone;

    @NotNull
    private String addr;

    @NotNull
    private String detail;
}
