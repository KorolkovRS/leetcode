package ru.korolkovrs;

public class Task2 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String maxPrefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            String substring = strs[0].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(substring)) {
                    return maxPrefix;
                }
            }
            maxPrefix = substring;
        }
        return maxPrefix;
    }
}
