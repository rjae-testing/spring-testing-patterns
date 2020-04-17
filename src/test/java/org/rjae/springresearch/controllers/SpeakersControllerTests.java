package org.rjae.springresearch.controllers;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.models.Speaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SpeakersControllerTests {
    @Test
    void listMustReturnEmptyListWhenSpeakerIsEmpty() {
        assertEquals(0, new SpeakersController(new MockSpeakerRepository()).list().size());
    }

    @Test
    void createMustCreateSpeakerInSpeaker() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test & Co", "Bob Smith tests");
        expected.setId(1L);
        controller.create(expected);
        Speaker actual = controller.get(1L);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }

    @Test
    void updateMustUpdateSpeakerInSpeaker() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test & Co", "Bob Smith tests");
        expected.setId(1L);
        controller.create(expected);
        expected = new Speaker("Bob", "Smith", "Tester", "Test & Co", "Bob Smith tests");
        expected.setId(1L);
        controller.update(1L, expected);
        Speaker actual = controller.get(1L);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }

    @Test
    void deleteMustDeleteSpeakerInSpeaker() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test & Co", "Bob Smith tests");
        expected.setId(1L);
        controller.create(expected);
        assertEquals(expected.getFirstName(), controller.get(1L).getFirstName());
        controller.delete(1L);
        assertNull(controller.get(1L));
    }
}
