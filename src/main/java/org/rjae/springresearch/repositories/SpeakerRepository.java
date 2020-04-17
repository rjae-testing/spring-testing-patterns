package org.rjae.springresearch.repositories;

import org.rjae.springresearch.models.Speaker;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
