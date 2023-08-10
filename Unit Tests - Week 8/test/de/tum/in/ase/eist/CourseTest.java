package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    public void testGetCourseTitle() {
        Course course = new Course("Test");
        assertEquals("Test", course.getTitle());
    }
	@Test
    public void testNoAttendees() {
        Course course = new Course("Test");
        assertEquals(0, course.getNumberOfAttendees());
    }

    @Test
    public void testThreeAttendees() {
        Course course = new Course("Test");
        course.addAttendee(new Student("Mohammed", "Thabit", "14.06.2003", "CS", "Business"));
        course.addAttendee(new Student("Ali", "Thabit", "14.06.2003", "CS", "Business"));
        course.addAttendee(new Student("Felipe", "Thabit", "14.06.2003", "CS", "Business"));
        assertEquals(3, course.getNumberOfAttendees());
    }

}
