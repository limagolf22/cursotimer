package org.cursotimer;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LocalDate startDate;
        System.out.println("App Started!");
        if (args.length <= 1) {
            LOGGER.log(Level.SEVERE, () -> "Not enough arguments");
        }
        try {
            startDate = WorkChecks.dateFrom(args[1]);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        WorkChecks workChecks = new WorkChecks(startDate);
        if (args.length > 2) {

            try {
                LocalDate endDate = WorkChecks.dateFrom(args[2]);
                workChecks.setEndingDate(endDate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        while (workChecks.isWithin()) {

            if (workChecks.isWorkingDay()) {
                Actuator actuator = new ActuatorAddWorkload(workChecks.getCurrentDate());

                actuator.apply(robot);
                LOGGER.log(Level.INFO, () -> "Day " + workChecks.getCurrentDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + " has been treated");
            }

            workChecks.moveToNextDay();
        }

    }

}
