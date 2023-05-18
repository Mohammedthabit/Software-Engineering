package de.tum.in.ase.eist;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public abstract class TimeSlot {
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(LocalTime x, LocalTime y){
        this.startTime = x;
        this.endTime = y;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
