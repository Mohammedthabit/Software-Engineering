package de.tum.in.ase.eist;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
    private String url;

    public VirtualTutorGroupMeeting(FixedDateTimeSlot fixedDateTimeSlot, TutorGroup tutorGroup, Skill skill, String url){
        super(fixedDateTimeSlot, tutorGroup, skill);
        this.url = url;
    }

    public void practise(){
        getTutorGroup().getTutor().say("Thank you for joining using " + url + " today.");
        getTutorGroup().getStudents().forEach(student -> student.learnSkill(getSkillToPractise()));
        getTutorGroup().getTutor().say("See you next time!");
    }

    public String getUrl() {
        return url;
    }
}
