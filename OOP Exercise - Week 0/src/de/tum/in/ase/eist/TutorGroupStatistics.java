package de.tum.in.ase.eist;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TutorGroupStatistics {

	private TutorGroupStatistics() {

	}

	public static double averageDuration(Stream<TutorGroupMeeting> meetingStream) {
		return meetingStream.mapToLong(TutorGroupMeeting -> TutorGroupMeeting.getTimeSlot().getDuration().getSeconds())
				.average()
				.orElse(0.0);
	}

	public static Set<Skill> repeatedSkills(Stream<TutorGroupMeeting> meetings) {
		List<Skill> list = meetings.map(meet -> meet.getSkillToPractise()).collect(Collectors.toList());
		return list.stream()
				.filter(x -> Collections.frequency(list, x) > 1)
				.collect(Collectors.toSet());
	}
}
