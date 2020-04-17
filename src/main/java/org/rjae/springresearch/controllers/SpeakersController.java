package org.rjae.springresearch.controllers;

import org.rjae.springresearch.models.Speaker;
import org.rjae.springresearch.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    private final SpeakerRepository itsRepository;

    @Autowired
    public SpeakersController(SpeakerRepository itsRepository) {
        this.itsRepository = itsRepository;
    }

    @GetMapping
    public List<Speaker> list() {
        return itsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return itsRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker) {
        return itsRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        itsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = itsRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "itsId");
        return itsRepository.saveAndFlush(existingSpeaker);
    }
}
