package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * Created by khurram on 21/11/2017.
 */
public class BerlinClock implements TimeConverter {


    public static final char RED = 'R';
    public static final char YELLOW = 'Y';
    public static final char OFF ='O';

    @Override
    public String convertTime(String aTime) {
        int[] time = Arrays.asList(aTime.split(":")).stream().mapToInt(Integer::parseInt).toArray();
        return processSeconds(time[2])+
                processHours(time[0]);

    }

    private String processSeconds(int seconds) {
        return ((seconds % 2 == 0) ? YELLOW : OFF) + "\n";
    }

    private String processHours(int hours){
        return  processLamps(4, hours/5, RED)+
                processLamps(4,hours%5, RED);
    }



    private String processLamps(int rowLampCount, int onCount, char onSign){
        StringBuffer row = new StringBuffer("");
        for(int i =0; i<onCount; i++){
            row.append(onSign);
        }
        for(int i=onCount; i<rowLampCount ; i++){
            row.append(OFF);
        }
        return row.append("\n").toString();

    }


}
