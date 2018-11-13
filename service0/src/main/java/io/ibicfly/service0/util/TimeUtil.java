package io.ibicfly.service0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.DelayQueue;

public class TimeUtil {
    /**
     *  date1 "2018-08-09 23:00"
     *  date2 "2018-08-09 "
     *  date3 "2018-08-09 12:00:00"
     */
    private static final SimpleDateFormat date1Fromat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat date2Format = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat date3Fromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    public static void main(String[] args) throws ParseException {
        String a="2018-09-09 06:00";
        String b="2018-09-12 07:00";
        a=a.substring(0,10)+" 12:00";
//        System.out.println(conversionTimeUpdown(a));
        try {
            for(String temp:calTimeToList(a,b))
            {
                System.out.println(temp.substring(0,temp.length()-1));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static String conversionTimeUpdown(String time)
    {
        DelayQueue queue=new DelayQueue();
        StringBuffer operationDate = new StringBuffer();
        try {
            //字符串转date
            Date date1 = date1Fromat.parse(time);
            //date转成字符串
            operationDate.append(date2Format.format(date1));
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date2Format.parse(time));
            calendar.add(Calendar.HOUR_OF_DAY,12);
            if(date1.before(calendar.getTime()))
                operationDate.append(0);
            else
                operationDate.append(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationDate.toString();
    }
    public static List<String> calTimeToList(String startTime,String endTime) throws ParseException {
        List<String> timeList=new ArrayList<>();
        Calendar startCal = Calendar.getInstance();
        Date startDate=date1Fromat.parse(startTime);
        Date endDate=date1Fromat.parse(endTime);
        startCal.setTime(startDate);
        while(startDate.before(endDate))
        {
            String temp1=date1Fromat.format(startDate);
            String temp=conversionTimeUpdown(temp1);
            timeList.add(temp);
            startCal.add(Calendar.HOUR_OF_DAY, 12);
            startDate=startCal.getTime();
        }
        return timeList;
    }
    public static long dayDiff(String startDate,String endDate)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1=Calendar.getInstance();
        Calendar calendar2=Calendar.getInstance();
        try {
            calendar1.setTime(sdf.parse(startDate));
            calendar2.setTime(sdf.parse(endDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dayNum=(calendar2.getTimeInMillis()-calendar1.getTimeInMillis())/(1000*3600*24);
        return dayNum;
    }
    public static String getNowHHMMSS()
    {
        return date3Fromat.format(new Date());
    }
}
