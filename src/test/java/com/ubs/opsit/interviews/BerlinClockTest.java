package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by khurram on 21/11/2017.
 */
public class BerlinClockTest {


    public static final String YELLOW = "Y";
    public static final String OFF = "O";
    TimeConverter clock = new BerlinClock();

    @Test
    public void evenSecondsShouldShowTopLightsAsYellow(){
        String[] time = clock.convertTime("00:00:00").split("\n");
        assertThat(time[0]).isEqualTo(YELLOW);
        time = clock.convertTime("00:00:24").split("\n");
        assertThat(time[0]).isEqualTo(YELLOW);
    }

    @Test
    public void oddSecondsShouldShowTopLightAsOff(){
        String[] time = clock.convertTime("00:00:01").split("\n");
        assertThat(time[0]).isEqualTo(OFF);
        time = clock.convertTime("00:00:59").split("\n");
        assertThat(time[0]).isEqualTo(OFF);
    }

    @Test
    public void secondRowShouldShowRedLightsForHoursPastInMultipleOfFives(){
        String[] time = clock.convertTime("01:00:00").split("\n");
        assertThat(time[1]).isEqualTo("OOOO");

        time = clock.convertTime("13:00:00").split("\n");
        assertThat(time[1]).isEqualTo("RROO");
    }

    @Test
    public void thirdRowRowShouldShowRedLightsForHoursPastInRemainderOfFive(){
        String[] time = clock.convertTime("01:00:00").split("\n");
        assertThat(time[2]).isEqualTo("ROOO");

        time = clock.convertTime("13:00:00").split("\n");
        assertThat(time[2]).isEqualTo("RRRO");
    }


}
