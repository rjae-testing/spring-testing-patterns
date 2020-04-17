package org.rjae.springresearch.controllers;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.models.Speaker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SpeakersControllerTests {
    @Test
    void createMustCreateSpeakerInSpeaker() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test & Co", "Bob Smith tests");
        expected.setId(1L);
        Speaker actual = controller.create(expected);
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

    @Test
    void listMustReturnEmptyListWhenSpeakerIsEmpty() {
        assertEquals(0, new SpeakersController(new MockSpeakerRepository()).list().size());
    }

    @Test
    void listMustReturnSpeakerInSpeakers() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test co", "Bob tests");
        expected.setId(1L);
        controller.create(expected);
        List<Speaker> speakers = controller.list();
        Speaker actual = speakers.stream().filter(x -> x.getId() == 1L).findFirst().orElseThrow();
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }

    @Test
    void updateMustUpdateSpeakerInSpeaker() {
        SpeakersController controller = new SpeakersController(new MockSpeakerRepository());
        Speaker expected = new Speaker("Bob", "Smith", "Tester", "Test co", "Bob tests");
        expected.setId(1L);
        controller.create(expected);
        expected = new Speaker("Bob", "Smith", "Tester", "Test co", "Bob Smith tests");
        expected.setId(1L);
        Speaker actual = controller.update(1L, expected);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }
}
