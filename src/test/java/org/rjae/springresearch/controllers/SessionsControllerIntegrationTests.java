package org.rjae.springresearch.controllers;

import org.junit.jupiter.api.Test;
import org.rjae.springresearch.SpringResearchApplication;
import org.rjae.springresearch.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringResearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SessionsControllerIntegrationTests {
    @Autowired
    private TestRestTemplate itsClient;
    @LocalServerPort
    private int itsPort;

    @Test
    void createMustAddSessionToSessions() {
        String url = String.format("http://localhost:%d/api/v1/sessions", itsPort);
        Session expected = itsClient.postForObject(url, new Session("Meet Bob", "Meet Bob Smith", 42), Session.class);
        Session[] sessions = itsClient.getForObject(url, Session[].class);
        Session actual = Arrays.stream(sessions).filter(s -> s.getId().equals(expected.getId())).findFirst().orElseThrow();
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getLength(), actual.getLength());
        assertEquals(expected.getSpeakers(), actual.getSpeakers());
    }

    @Test
    void deleteMustDeleteSessionFromSessions() {
        String url = String.format("http://localhost:%d/api/v1/sessions", itsPort);
        Session expected = itsClient.postForObject(url, new Session("Meet Bob", "Meet Bob Smith", 42), Session.class);
        Session[] sessions = itsClient.getForObject(url, Session[].class);
        Arrays.stream(sessions).filter(s -> s.getId().equals(expected.getId())).findFirst().orElseThrow();
        itsClient.delete(String.format("%s/%d", url, expected.getId()));
        sessions = itsClient.getForObject(url, Session[].class);
        assertTrue(Arrays.stream(sessions).noneMatch(s -> s.getId().equals(expected.getId())));
    }

    @Test
    void updateMustUpdateSessionInSessions() {
        String url = String.format("http://localhost:%d/api/v1/sessions", itsPort);
        Session expected = itsClient.postForObject(url, new Session("Meet Bob", "Meet Bob Smith", 42), Session.class);
        Session[] sessions = itsClient.getForObject(url, Session[].class);
        Arrays.stream(sessions).filter(s -> s.getId().equals(expected.getId())).findFirst().orElseThrow();
        expected.setLength(45);
        itsClient.put(String.format("%s/%d", url, expected.getId()), expected);
        Session actual = itsClient.getForObject(String.format("%s/%d", url, expected.getId()), Session.class);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getLength(), actual.getLength());
        assertEquals(expected.getSpeakers(), actual.getSpeakers());
    }
}

