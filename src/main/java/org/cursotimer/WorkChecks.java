package org.cursotimer;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkChecks {

    LocalDate currentDate;
    LocalDate endingDate;
    WorkChecks(LocalDate _startingDate) {
        currentDate = _startingDate;
        endingDate = _startingDate.plusDays(10);
    }

    public static LocalDate dateFrom(String date) throws ParseException {
        return LocalDate.parse(date);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setEndingDate(LocalDate _endingDate) {
        this.endingDate = _endingDate;
    }

    public boolean isWithin(){
        return !currentDate.isAfter(endingDate);
    }

    public boolean isWorkingDay(){
        return currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    public void moveToNextDay() {
        currentDate = currentDate.plusDays(1);
    }
}
