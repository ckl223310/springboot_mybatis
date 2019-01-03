package com.yh.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生请假信息
 * @author czh
 * @date 2019-01-03
 */
@Setter
@Getter
@ToString
public class StuLeaveInfoVO {


    /**
     * 学生Id
     */
    private String stuId;

    /**
     * 请假学生姓名
     */
    private String stuName;

    /**
     * 请假天数
     */
    private Integer days;

    /**
     * 请假原因
     */
    private String remark;

}
