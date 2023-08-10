package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class OnlineCourseTest {
    @Test
    public void testSetOnlineCourseUrlWithValidUrl() throws MalformedURLException {
        OnlineCourse onlineCourse = new OnlineCourse("Test");
        onlineCourse.setUrl("http://www.example.com/index.html");
        assertEquals("http://www.example.com/index.html", onlineCourse.getUrl().toString());
    }

    @Test
    public void testSetOnlineCourseUrlWithInvalidUrl() throws MalformedURLException {
        OnlineCourse onlineCourse = new OnlineCourse("Test");
        assertThrows(MalformedURLException.class, () -> {
            onlineCourse.setUrl("google");
        });
    }
}
