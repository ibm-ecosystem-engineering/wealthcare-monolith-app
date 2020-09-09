package com.gan.wcare.common;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    public static String add(String number1, int number2) {
        int value = stringToInt(number1) + number2;
        String result = String.valueOf(value);
        return result;
    }

    public static int stringToInt(String number1) {
        int result = 0;
        try{
            result = Integer.parseInt(number1);
        } catch (Exception e) {
        }
        return result;
    }
    public static double stringToDouble(String number1) {
    	double result = 0;
        try{
            result = Double.parseDouble(number1);
        } catch (Exception e) {
        }
        return result;
    }


    public static int  percentageIncrease(double initialValue, double currentValue) {
        int result = 0;

        double difference = currentValue - initialValue;

        int value = (int) (divide(difference, initialValue) * 100);
        return value;
    }

    public static int  percentage(double value1, double value2) {
        int result = 0;

        int value = (int) (divide(value2, value1) * 100);
        return value;
    }

    public static double  percentage(double value1, double value2, double value3) {
        double value = (divide(value2, value1) * value3);
        return value;
    }

    public static double divide(double n1, double n2) {
        double result = 0;
        try {
            result = n1 / n2;
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return result;
    }

    public static double getCurrentFD(double amount, long diffDays) {
        LogUtil.log("FinanceQuoteService : getCurrentFD : started");
        LogUtil.log("FinanceQuoteService : getCurrentFD : diffDays : " + diffDays);

        if (diffDays <= 0) {
            diffDays = 1;
        }
        double increasePercentage = NumberUtil.percentage(365.0, 0.12, diffDays);
        double result = amount + (amount * increasePercentage);

        LogUtil.log("FinanceQuoteService : getCurrentFD : increasePercentage : " + increasePercentage);
        LogUtil.log("FinanceQuoteService : getCurrentFD : amount : " + amount);
        LogUtil.log("FinanceQuoteService : getCurrentFD : result : " + result);

        return result;
    }

    public static List<Integer> createPercentageCompletionList(int completedPercentage) {
        List<Integer> list = new ArrayList<>();
        list.add(completedPercentage);
        list.add(100-completedPercentage);
        return list;
    }

    public static void main(String[] args) {

        System.out.println(getCurrentFD(150000 ,1588));
        System.out.println(getCurrentFD(100000 ,1588));
        System.out.println(getCurrentFD(1500 ,1527));



    }
    
}
