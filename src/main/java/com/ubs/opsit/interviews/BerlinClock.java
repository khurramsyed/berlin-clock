package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

/**
 * Created by khurram on 21/11/2017.
 */
public class BerlinClock implements TimeConverter {


    public static final String RED = "R";
    public static final String YELLOW = "Y";
    public static final String OFF = "O";

    @Override
    public String convertTime(String timeAsString) {

        validateInput(timeAsString);

        int[] timeComponentsAsInt = Arrays.asList(timeAsString.split(":")).stream().mapToInt(Integer::parseInt).toArray();

        return processSeconds(timeComponentsAsInt[2])+
                processHours(timeComponentsAsInt[0])+
                processMinutes(timeComponentsAsInt[1]);

    }

    private void validateInput(String timeAsString) {
        if(! Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]", timeAsString)){
            throw new IllegalArgumentException("Format of time is HH:MM:SS and "+timeAsString+ " does not conform to this format");
        }
    }

    private String processSeconds(int seconds) {
        return ((seconds % 2 == 0) ? YELLOW : OFF) + "\n";
    }

    private String processHours(int hours){
        return  processLamps(4, hours/5, RED)+
                processLamps(4,hours%5, RED);
    }

    private String processMinutes(int minutes){
        return processMinutesFirstRow(minutes)+
                ( processLamps(4, minutes%5, YELLOW).replaceFirst("\n",""));
    }

    private String processMinutesFirstRow(int minutes){
        String minutesRow = processLamps(11, minutes/5 , YELLOW);
        return minutesRow.replaceAll("YYY","YYR");

    }

    private String processLamps(int rowLampCount, int onCount, String onSign){
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
