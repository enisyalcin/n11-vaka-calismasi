package com.example.n11vakacalismasi.utils;

/**
 * @author : PC
 * @date : 05/06/2024
 */
public class Utils {
    public static int convertDurationToMinutes(String duration) {
        if (duration.endsWith("min")) {
            String minutesStr = duration.substring(0, duration.length() - 3);
            return Integer.parseInt(minutesStr);
        } else if (duration.equals("lightning")) {
            return 5;
        } else {
            throw new IllegalArgumentException("Invalid duration format");
        }
    }

    public static String convertMinutesToString(long duration) {
        String result;
        if (duration == 5) {
            result = new String("lightning");
        } else if (duration > 5) {
            result = String.format("%dmin", duration);
        } else {
            throw new IllegalArgumentException("Invalid duration format");
        }
        return result;
    }
}
