package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by khurram on 21/11/2017.
 */
public class BerlinClockTest {


    TimeConverter clock = new BerlinClock();

    @Test
    public void evenSecondsShouldShowTopLightsAsYellow(){
        String[] time = clock.convertTime("00:00:00").split("\n");
        assertThat(time[0]).isEqualTo(BerlinClock.YELLOW);
        time = clock.convertTime("00:00:24").split("\n");
        assertThat(time[0]).isEqualTo(BerlinClock.YELLOW);
    }

    @Test
    public void oddSecondsShouldShowTopLightAsOff(){
        String[] time = clock.convertTime("00:00:01").split("\n");
        assertThat(time[0]).isEqualTo(BerlinClock.OFF);
        time = clock.convertTime("00:00:59").split("\n");
        assertThat(time[0]).isEqualTo(BerlinClock.OFF);
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



    @Test
    public void fourthRowShouldShowLightsForMinutesPastInMultipleOfFives(){
        String[] time = clock.convertTime("01:07:00").split("\n");
        assertThat(time[3]).isEqualTo("YOOOOOOOOOO");


        time = clock.convertTime("13:27:00").split("\n");
        assertThat(time[3]).isEqualTo("YYRYYOOOOOO");
    }

    @Test
    public void fourthRowRowShouldShowEveryQuarterOfHourIsRed(){
        String[] time = clock.convertTime("01:20:00").split("\n");
        assertThat(time[3]).isEqualTo("YYRYOOOOOOO");


        time = clock.convertTime("13:57:00").split("\n");
        assertThat(time[3]).isEqualTo("YYRYYRYYRYY");
    }


    @Test
    public void fifthRowShouldShowMinutesInRemainderOfFive(){
        String[] time = clock.convertTime("01:01:00").split("\n");
        assertThat(time[4]).isEqualTo("YOOO");

        time = clock.convertTime("23:04:00").split("\n");
        assertThat(time[4]).isEqualTo("YYYY");

        time = clock.convertTime("23:53:00").split("\n");
        assertThat(time[4]).isEqualTo("YYYO");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithWrongMinutes(){
        clock.convertTime("01:60:00").split("\n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithWrongHourFormat(){
        clock.convertTime("24:59:00").split("\n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithWrongSecondFormat(){
        clock.convertTime("23:59:60").split("\n");
    }



}
