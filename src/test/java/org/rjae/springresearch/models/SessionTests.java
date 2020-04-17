package org.rjae.springresearch.models;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.models.Session;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTests {
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
    void setDescriptionMustSetDescription() {
        Session session = new Session();
        session.setDescription("Meet Bob");
        assertEquals("Meet Bob", session.getDescription());
    }
}
