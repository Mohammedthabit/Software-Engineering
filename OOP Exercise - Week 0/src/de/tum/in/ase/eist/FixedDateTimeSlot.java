package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.time.LocalTime;

public class FixedDateTimeSlot extends TimeSlot {
    private LocalDate date;

    public FixedDateTimeSlot(LocalDate x, LocalTime y, LocalTime z){
        super(y, z);
        this.date = x;
    }

    public LocalDate getDate() {
        return date;
    }
}
