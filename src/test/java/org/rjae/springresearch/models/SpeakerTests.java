package org.rjae.springresearch.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpeakerTests {
    @Test
    void setBioMustSetBio() {
        Speaker speaker = new Speaker();
        speaker.setBio("Test");
        assertEquals("Test", speaker.getBio());
    }

    @Test
    void setCompanyMustSetCompany() {
        Speaker speaker = new Speaker();
        speaker.setCompany("Acme");
        assertEquals("Acme", speaker.getCompany());
    }

    @Test
    void setFirstNameMustSetFirstName() {
        Speaker speaker = new Speaker();
        speaker.setFirstName("Bob");
        assertEquals("Bob", speaker.getFirstName());
    }

    @Test
    void setIdMustSetId() {
        Speaker speaker = new Speaker();
        speaker.setId(42L);
        assertEquals(42L, speaker.getId());
    }

    @Test
    void setLastNameMustSetLastName() {
        Speaker speaker = new Speaker();
        speaker.setLastName("Smith");
        assertEquals("Smith", speaker.getLastName());
    }

    @Test
    void setPhotoMustSetPhoto() {
        Speaker speaker = new Speaker();
        speaker.setPhoto("42".getBytes());
        assertArrayEquals("42".getBytes(), speaker.getPhoto());
    }

    @Test
    void setSessionsMustSetSessions() {
        Speaker speaker = new Speaker();
        Session session = new Session("Meet Bob", "Meet Bob Smith", 42);
        session.setId(1L);
        speaker.setSessions(List.of(session));
        assertTrue(speaker.getSessions().stream().anyMatch(x -> x.getId() == 1L));
    }

    @Test
    void setTitleMustSetTitle() {
        Speaker speaker = new Speaker();
        speaker.setTitle("Security");
        assertEquals("Security", speaker.getTitle());
    }
}
