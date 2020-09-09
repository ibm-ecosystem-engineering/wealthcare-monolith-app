package com.gan.wcare.common;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    static String patternMMMYYYY = "MMM yyyy";
    static String patternDDMMMYYYY = "dd-MMM-yyyy";

    public static String convertMMMYYY(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternMMMYYYY);
        String dateString = "";
        try {
            dateString = simpleDateFormat.format(date);
        } catch (Exception e) {
        	e.printStackTrace();
        }        return dateString;
    }

    public static String convertDDMMMYYY(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDDMMMYYYY);
        String dateString = "";
        try {
            dateString = simpleDateFormat.format(date);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return dateString;
    }

    public static long dateDiffInDays(Date latest, Date previous) {
        long diffDays = 0;
        try {
            //in milliseconds
            long diff = latest.getTime() - previous.getTime();
            diffDays = diff / (24 * 60 * 60 * 1000);
//            System.out.print(diffDays + " days, ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return diffDays;
    }

    public static int dateDiffInYears(Date latest, Date previous) {
        long diffYears = 0;
        try {
            //in milliseconds
            long diff = latest.getTime() - previous.getTime();

            LogUtil.logDebug("DateUtil dateDiffInYears : diff 0000 " + diff );
            diffYears = TimeUnit.MILLISECONDS.toDays(diff) / 365l;

            LogUtil.logDebug("DateUtil dateDiffInYears : diffYears " + diffYears );

//            System.out.print(diffYears + " years, ");
        } catch (Exception e) {
            e.printStackTrace();
        }


        LogUtil.logDebug("DateUtil dateDiffInYears : latest " + latest );
        LogUtil.logDebug("DateUtil dateDiffInYears : previous " + previous );
        LogUtil.logDebug("DateUtil dateDiffInYears : diffYears " + diffYears );

        return (int) diffYears;
    }

    public static boolean isLimitExceeded(long latestTimeInMilliSeconds, long previousTimeInMilliSeconds, long differenceLimitInSeconds) {
        boolean result = true;
        try {
            long differenceLimitInMilliSeconds = differenceLimitInSeconds * 1000;
            long difference = latestTimeInMilliSeconds - previousTimeInMilliSeconds;
            if (difference < differenceLimitInMilliSeconds) {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.logDebug("DateUtil isLimitExceeded : latestTimeInMilliSeconds " + latestTimeInMilliSeconds );
        LogUtil.logDebug("DateUtil isLimitExceeded : previousTimeInMilliSeconds " + previousTimeInMilliSeconds );
        LogUtil.logDebug("DateUtil isLimitExceeded : differenceLimitInSeconds " + differenceLimitInSeconds );
        LogUtil.logDebug("DateUtil isLimitExceeded : result " + result );
        return result;
    }

    public static void main(String[] args) {
        Date date1 = getDate("7-06-2013");
        Date date2 = getDate("7-06-2016");
        System.out.println(dateDiffInYears(date1, date2));

    }

    public static Date getDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    //If the date coversion fails, it will return date by adding yeartoAdd years in today's date
    public static Date getDateDefaultToNYear(String dateString, int yearToAdd) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (Exception e) {
        	e.printStackTrace();
        	date = addYearToToday(yearToAdd);
        }
        return date;
    }
    

    public static Date addYearToToday(int yearToAdd) {
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.YEAR, yearToAdd);
    	return c.getTime();
    }
    
}