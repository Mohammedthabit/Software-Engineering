package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TutorGroupMeeting {
    private static final int NUMBER_OF_HOMEWORK_PRESENTATIONS = 3;
    protected final TimeSlot timeSlot;
    protected final TutorGroup tutorGroup;
    protected final Skill skillToPractice;

    public TutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice) {
        this.timeSlot = timeSlot;
        this.tutorGroup = tutorGroup;
        this.skillToPractice = skillToPractice;
    }

    public TutorGroup getTutorGroup() {
        return tutorGroup;
    }

    public Skill getSkillToPractice() {
        return skillToPractice;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void practice() {
        Student tutor = tutorGroup.getTutor();
        intro();
        List<Student> homeworkPresentationCandidates = new ArrayList<>(tutorGroup.getStudents());
        for (int i = 0; i < NUMBER_OF_HOMEWORK_PRESENTATIONS; i++) {
            if (homeworkPresentationCandidates.isEmpty()) {
                break;
            }
            int randomIndex = ThreadLocalRandom.current().nextInt(homeworkPresentationCandidates.size());
            Student randomStudent = homeworkPresentationCandidates.get(randomIndex);
            randomStudent.presentHomework();
            homeworkPresentationCandidates.remove(randomIndex);
        }

        tutor.say("Next is the group work");

        for (Student student : tutorGroup.getStudents()) {
            student.learnSkill(skillToPractice);
        }
        skillToPractice.apply();

        tutor.say("Let's have a look at the new homework");
        tutor.say("Thank you that you have participated " + getLocation() + " today.");
        tutor.say("See you next time!");
    }

    protected abstract void intro();

    protected abstract String getLocation();
}


