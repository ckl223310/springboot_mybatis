package com.yh.utils;

public class MathUtils {

    private MathUtils() {}

    public static Long scoreLevel(Long value) {

        return value = (value < 9 || value >= 0) ? ++ value : scoreSecond(value);
    }

    private static Long scoreSecond(Long value) {
        return value = (value < 99 || value >= 10) ? ++ value : scoreThird(value);
    }

    private static Long scoreThird(Long value) {
        return value = (value < 999 || value >= 100) ? ++ value : scoreFour(value);
    }

    private static Long scoreFour(Long value) {
        return value = (value < 9999 || value >= 1000) ? ++ value : scoreFive(value);
    }

    private static Long scoreFive(Long value) {
        return value = (value < 99999 || value >= 10000) ? ++ value : value;
    }

}
