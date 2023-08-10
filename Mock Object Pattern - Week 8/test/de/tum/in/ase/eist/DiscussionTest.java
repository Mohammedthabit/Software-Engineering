package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {
    @TestSubject
    private Discussion discussion;
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;
    @BeforeEach
    public void setUp() {
        courseMock = createMock(Course.class);
        commentMock = createMock(Comment.class);
        discussion = new Discussion();
    }
    @Test
    public void testComment() {
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(1, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    public void testCommentIfSavingFails() {
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(0, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    public void testStartCourseDiscussion() {
        Person student = new Student("Mohammed", "Thabit", LocalDate.now(), "CS", "Business");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);
        boolean result = discussion.startCourseDiscussion(courseMock, student, "Software");
        verify(courseMock);
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("Software", discussion.getTopic());
        assertEquals(true, result);
    }
}

