package org.rjae.springresearch.controllers;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.SpringResearchApplication;
import org.rjae.springresearch.models.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringResearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpeakersControllerIntegrationTests {
    @LocalServerPort
    private int itsPort;
    @Autowired
    private TestRestTemplate itsClient;

    @Test
    void listMustReturnEmptySpeakersWhenSpeakersIsEmpty() {
        String url = String.format("http://localhost:%d/api/v1/speakers", itsPort);
        assertEquals(0, itsClient.getForObject(url, Speaker[].class).length);
    }

    @Test
    void createMustAddSpeakerToSpeakers() {
        String url = String.format("http://localhost:%d/api/v1/speakers", itsPort);
        Speaker expected = itsClient.postForObject(url, new Speaker("Bob", "Smith", "Tester", "Test", "Bob tests stuff"), Speaker.class);
        Speaker[] speakers = itsClient.getForObject(url, Speaker[].class);
        Speaker actual = Arrays.stream(speakers).filter(x -> x.getId().equals(expected.getId())).findFirst().orElseThrow();
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }

    @Test
    void deleteMustDeleteSpeakerFromSpeakers() {
        String url = String.format("http://localhost:%d/api/v1/speakers", itsPort);
        Speaker expected = itsClient.postForObject(url, new Speaker("Bob", "Smith", "Tester", "Test", "Bob tests stuff"), Speaker.class);
        Speaker[] speakers = itsClient.getForObject(url, Speaker[].class);
        Arrays.stream(speakers).filter(x -> x.getId().equals(expected.getId())).findFirst().orElseThrow();
        itsClient.delete(String.format("%s/%d", url, expected.getId()));
        speakers = itsClient.getForObject(url, Speaker[].class);
        assertTrue(Arrays.stream(speakers).noneMatch(x -> x.getId().equals(expected.getId())));
    }

    @Test
    void updateMustUpdateSpeakerInSpeakers() {
        String url = String.format("http://localhost:%d/api/v1/speakers", itsPort);
        Speaker expected = itsClient.postForObject(url, new Speaker("Bob", "Smith", "Tester", "Test", "Bob tests stuff"), Speaker.class);
        Speaker[] speakers = itsClient.getForObject(url, Speaker[].class);
        Arrays.stream(speakers).filter(x -> x.getId().equals(expected.getId())).findFirst().orElseThrow();
        expected.setPhoto(new byte[] {(byte) 4, (byte) 3});
        itsClient.put(String.format("%s/%d", url, expected.getId()), expected);
        Speaker actual = itsClient.getForObject(String.format("%s/%d", url, expected.getId()), Speaker.class);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompany(), actual.getCompany());
        assertEquals(expected.getBio(), actual.getBio());
    }
}
