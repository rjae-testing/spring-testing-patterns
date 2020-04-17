package org.rjae.springresearch.controllers;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.models.Session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SessionsControllerTests {
    @Test
    void listMustReturnEmptyListWhenSessionsIsEmpty() {
        assertEquals(0, new SessionsController(new MockSessionRepository()).list().size());
    }

    @Test
    void createMustCreateSessionInSessions() {
        SessionsController controller = new SessionsController(new MockSessionRepository());
        Session expected = new Session("Meet Bob", "Meet Bob Smith", 42);
        expected.setId(1L);
        controller.create(expected);
        Session actual = controller.get(1L);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getLength(), actual.getLength());
        assertEquals(expected.getSpeakers(), actual.getSpeakers());
    }

    @Test
    void updateMustUpdateSessionInSessions() {
        SessionsController controller = new SessionsController(new MockSessionRepository());
        Session expected = new Session("Meet Bob", "Meet Bob Smith", 42);
        expected.setId(1L);
        controller.create(expected);
        expected = new Session("Meet Bob", "Meet Bob Smith", 45);
        expected.setId(1L);
        controller.update(1L, expected);
        Session actual = controller.get(1L);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getLength(), actual.getLength());
        assertEquals(expected.getSpeakers(), actual.getSpeakers());
    }

    @Test
    void deleteMustDeleteSessionInSessions() {
        SessionsController controller = new SessionsController(new MockSessionRepository());
        Session expected = new Session("Meet Bob", "Meet Bob Smith", 42);
        expected.setId(1L);
        controller.create(expected);
        assertEquals(expected.getName(), controller.get(1L).getName());
        controller.delete(1L);
        assertNull(controller.get(1L));
    }
}
