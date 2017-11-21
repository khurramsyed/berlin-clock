package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * Created by khurram on 21/11/2017.
 */
public class BerlinClock implements TimeConverter {


    public static final char RED = 'R';
    public static final char OFF = 'O';
    public static final char YELLOW = 'Y';

    @Override
    public String convertTime(String aTime) {
        int[] time = Arrays.asList(aTime.split(":")).stream().mapToInt(Integer::parseInt).toArray();
        return processSeconds(time[2]);

    }

    private String processSeconds(int seconds) {
        return ((seconds % 2 == 0) ? YELLOW : OFF) + "\n";
    }

}
