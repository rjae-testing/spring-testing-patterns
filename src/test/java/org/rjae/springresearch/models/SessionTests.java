package org.rjae.springresearch.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionTests {
    @Test
    void setDescriptionMustSetDescription() {
        Session session = new Session();
        session.setDescription("Meet Bob");
        assertEquals("Meet Bob", session.getDescription());
    }

    @Test
    void setIdMustSetId() {
        Session session = new Session();
        session.setId(42L);
        assertEquals(42L, session.getId());
    }

    @Test
    void setLengthMustSetLength() {
        Session session = new Session();
        session.setLength(42);
        assertEquals(42, session.getLength());
    }

    @Test
    void setNameMustSetName() {
        Session session = new Session();
        session.setName("Meet Bob");
        assertEquals("Meet Bob", session.getName());
    }

    @Test
    void setSpeakersMustSetSpeakers() {
        Session session = new Session();
        Speaker speaker = new Speaker("Bob", "Smith", "Tester", "Testco", "Bob tests stuff");
        speaker.setId(1L);
        session.setSpeakers(List.of(speaker));
        assertTrue(session.getSpeakers().stream().anyMatch(x -> x.getId() == 1L));
    }
}
