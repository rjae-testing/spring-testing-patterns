package org.rjae.springresearch.controllers;

import org.rjae.springresearch.models.Session;
import org.rjae.springresearch.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    private final SessionRepository itsRepository;

    @Autowired
    public SessionsController(SessionRepository repository) {
        itsRepository = repository;
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return itsRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        itsRepository.deleteById(id);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return itsRepository.getOne(id);
    }

    @GetMapping
    public List<Session> list() {
        return itsRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = itsRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "itsId");
        return itsRepository.saveAndFlush(existingSession);
    }
}
