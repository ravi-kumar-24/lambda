package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CalenderScheduling {

    public static void main(String[] args) {
        String sxtr ="Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50" +
                "\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15"+
        "\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40"+
        "\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00";
        populateCalender(sxtr);

    }

    public static void populateCalender(String str){
        String[] list = str.split("\n");
        List<String> stringList =Arrays.stream(list).collect(Collectors.toList());

        int[] mins = new int[10080];
        sortDays(stringList);




    }

    public static void sortDays(List<String> dates ){
        Comparator<String> dateComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                try{
                    SimpleDateFormat format = new SimpleDateFormat("EEE");
                    Date d1 = format.parse(s1);

                    Date d2 = format.parse(s2);
                    if(d1.equals(d2)){
                        return s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1));
                    }else{


                        Calendar cal1 = Calendar.getInstance();
                        cal1.setFirstDayOfWeek(Calendar.MONDAY);
                        format.setCalendar( cal1 );

                        Calendar cal2 = Calendar.getInstance();
                        cal2.setFirstDayOfWeek(Calendar.MONDAY);
                        format.setCalendar( cal2 );

                        cal1.setTime(d1);
                        cal2.setTime(d2);
                        return cal1.get(Calendar.DAY_OF_WEEK) - cal2.get(Calendar.DAY_OF_WEEK);
                    }
                }catch(ParseException pe){
                    throw new RuntimeException(pe);
                }
            }
        };
        Collections.sort(dates, dateComparator);
        System.out.println(dates);
    }
}
