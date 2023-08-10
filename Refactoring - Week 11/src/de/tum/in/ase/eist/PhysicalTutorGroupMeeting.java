package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class PhysicalTutorGroupMeeting extends TutorGroupMeeting {
	private final String room;

	public PhysicalTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String room) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.room = room;
	}

	@Override
	protected void intro() {
		tutorGroup.getTutor().say("Welcome to the physical tutor meeting");
		tutorGroup.getTutor().say("Thank you for coming to " + room + " today.");
		tutorGroup.getTutor().say("We start with the homework presentation");
	}

	@Override
	protected String getLocation() {
		return "in " + room;
	}
}