package de.tum.in.ase.eist;

public abstract class TutorGroupMeeting {
    private FixedDateTimeSlot timeSlot;
    private Skill skillToPractise;
    private TutorGroup tutorGroup;

    public TutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise) {
        this.timeSlot = timeSlot;
        this.skillToPractise = skillToPractise;
        this.tutorGroup = tutorGroup;
    }

    public abstract void practise();

    public FixedDateTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Skill getSkillToPractise() {
        return skillToPractise;
    }

    public TutorGroup getTutorGroup() {
        return tutorGroup;
    }
}
