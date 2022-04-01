package com.hansung.android.androidproject1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateManager {
    Calendar calendar;

    // Calendar 클래스 인스턴스 생성
    public DateManager(){
        calendar = Calendar.getInstance();
    }

    //Get the elements of the month
    public List<Date> getDays(){
        //Keep current state
        Date startDate = calendar.getTime();

        //Calculate the total number of squares to be displayed in GridView
        int count = getWeeks() * 7 ;

        //Calculate the number of days for the previous month displayed on the calendar for the current month
        calendar.set(Calendar.DATE, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 주 획득
        calendar.add(Calendar.DATE, -dayOfWeek);

        List<Date> days = new ArrayList<>();

        for (int i = 0; i < count; i ++){
            days.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        //Restore state
        calendar.setTime(startDate);

        return days;
    }

    //Check if it is this month
    public boolean isCurrentMonth(Date date){
        SimpleDateFormat simpleform = new SimpleDateFormat("yyyy년 MM월", Locale.US);
        String currentMonth = simpleform.format(calendar.getTime());
        if (currentMonth.equals(simpleform.format(date))){
            return true;
        }else {
            return false;
        }
    }

    //해당 월의 마지막 주 구하기
    public int getWeeks(){
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    // 다음 달로 넘어가기 위해 현재 달에 +1
    public void nextMonth(){
        calendar.add(Calendar.MONTH, 1);
    }

    // 이전 달로 넘어가기 위해 현재 달에 -1
    public void prevMonth(){
        calendar.add(Calendar.MONTH, -1);
    }
}
