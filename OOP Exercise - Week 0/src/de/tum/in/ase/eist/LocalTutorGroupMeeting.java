package de.tum.in.ase.eist;

public class LocalTutorGroupMeeting extends TutorGroupMeeting {
    private String room;

    public LocalTutorGroupMeeting(FixedDateTimeSlot fixedDateTimeSlot, TutorGroup tutorGroup, Skill skill, String room){
        super(fixedDateTimeSlot, tutorGroup, skill);
        this.room = room;
    }

    public void practise(){
        getTutorGroup().getTutor().say("Thank you for coming to " + room + " today.");
        getTutorGroup().getStudents().forEach(student -> student.learnSkill(getSkillToPractise()));
        getTutorGroup().getTutor().say("See you next time!");
    }

    public String getRoom() {
        return room;
    }
}
