package com.yh.test;

import com.yh.entity.Student;
import junit.framework.TestCase;

/**
 * 添加类/接口功能描述
 *
 * @author czh
 * date 2019-04-29
 */
public class StudentTest extends TestCase {

    public void test() {
        Student student = new Student("czh");
        String stuName = student.getStuName();

        assertEquals("czh", stuName);

    }
}
