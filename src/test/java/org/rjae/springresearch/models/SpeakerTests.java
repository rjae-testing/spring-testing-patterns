package org.rjae.springresearch.models;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.models.Speaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeakerTests {
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
    void setTitleMustSetTitle() {
        Speaker speaker = new Speaker();
        speaker.setTitle("Security");
        assertEquals("Security", speaker.getTitle());
    }

    @Test
    void setCompanyMustSetCompany() {
        Speaker speaker = new Speaker();
        speaker.setCompany("Acme");
        assertEquals("Acme", speaker.getCompany());
    }

    @Test
    void setBioMustSetBio() {
        Speaker speaker = new Speaker();
        speaker.setBio("Test");
        assertEquals("Test", speaker.getBio());
    }
}
