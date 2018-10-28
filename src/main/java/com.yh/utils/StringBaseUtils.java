package com.yh.utils;


import com.yh.exception.StudentException;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class StringBaseUtils {

    private StringBaseUtils() {}

    public static String getId() {
       return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static boolean isPhone(String phone) {

        if(StringUtils.isEmpty(phone) || phone.length() != 11) {
            return false;
        }

        for (int i = 0; i < phone.length(); i++) {
            char ph = phone.charAt(i);
            if(ph < 48 || ph > 57) {
                return false;
            }
        }
        return true;
    }

    public static String getStuId(String lastId) throws StudentException {
        if(StringUtils.isEmpty(lastId) && lastId.length() != 8) {
            throw new StudentException("学生ID出现异常！");
        }

        String head = lastId.substring(0, 4);
        String last = lastId.substring(4, lastId.length());

        Integer lastInt = Integer.parseInt(last);

        if(lastInt.equals(9999)) {
            throw new StudentException("学生ID已达最大值！");
        }

        Long lastLong = MathUtils.scoreLevel(lastInt.longValue());

        return head + last;
    }
}
