package com.romantrippel.tllh.util;

import java.util.Objects;

public class StringUtil {
    public static boolean isEmptyOrBlank(String str) {
        return Objects.isNull(str) || str.isBlank();
    }
}