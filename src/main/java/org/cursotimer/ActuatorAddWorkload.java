package org.cursotimer;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

public class ActuatorAddWorkload implements Actuator{
    LocalDate date;
    public ActuatorAddWorkload(LocalDate _date) {
        date = _date;
    }

    @Override
    public void apply(Robot robot) {
        try {
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_A); //TODO
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
