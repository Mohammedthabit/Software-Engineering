package de.tum.in.ase.eist;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeeklyTimeSlot extends TimeSlot {
    private DayOfWeek dayOfWeek;

    public WeeklyTimeSlot(DayOfWeek x, LocalTime y, LocalTime z) {
        super(y, z);
        this.dayOfWeek = x;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
