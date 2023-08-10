package de.tum.in.ase.eist;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	private final URL url;

	public VirtualTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, URL url) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.url = url;
	}

	@Override
	public void intro() {
		tutorGroup.getTutor().say("Welcome to the virtual tutor meeting");
		tutorGroup.getTutor().say("Thank you for joining using " + url.toString() + " today.");
		tutorGroup.getTutor().say("Please turn on your cameras");
		tutorGroup.getTutor().say("We start with the homework presentation");
	}

	@Override
	protected String getLocation() {
		return "using the " + url;
	}

}
