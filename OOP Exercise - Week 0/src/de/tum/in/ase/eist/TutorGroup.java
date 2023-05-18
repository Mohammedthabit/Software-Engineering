package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TutorGroup {
    private String id;
    private WeeklyTimeSlot timeSlot;
    private Person tutor;
    private Set<Student> students = new HashSet<>();
    private List<TutorGroupMeeting> meetings = new LinkedList<>();

    public TutorGroup(String id, WeeklyTimeSlot timeSlot, Person tutor){
        this.id = id;
        this.timeSlot = timeSlot;
        this.tutor = tutor;
    }

    void addMeeting(TutorGroupMeeting groupMeeting) {}

    public void register(Student student){
        students.add(student);
    }

    public String getId() {
        return id;
    }

    public WeeklyTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Person getTutor() {
        return tutor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public List<TutorGroupMeeting> getMeetings() {
        return meetings;
    }
}
