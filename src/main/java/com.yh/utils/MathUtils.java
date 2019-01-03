package com.yh.utils;

/**
 * 工具类
 */
public class MathUtils {

    private MathUtils() {
    }

    /**
     * 分数等级
     * @param value
     * @return
     */
    public static Long scoreLevel(Long value) {

        return value = (value < 9 || value >= 0) ? ++value : scoreSecond(value);
    }

    /**
     * 分数等级
     * @param value
     * @return
     */
    private static Long scoreSecond(Long value) {
        return value = (value < 99 || value >= 10) ? ++value : scoreThird(value);
    }

    /**
     * 分数等级
     * @param value
     * @return
     */
    private static Long scoreThird(Long value) {
        return value = (value < 999 || value >= 100) ? ++value : scoreFour(value);
    }

    /**
     * 分数等级
     * @param value
     * @return
     */
    private static Long scoreFour(Long value) {
        return value = (value < 9999 || value >= 1000) ? ++value : scoreFive(value);
    }

    /**
     * 分数等级
     * @param value
     * @return
     */
    private static Long scoreFive(Long value) {
        return value = (value < 99999 || value >= 10000) ? ++value : value;
    }
}
