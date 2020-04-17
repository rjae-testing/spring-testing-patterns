package org.rjae.springresearch.repositories;

import org.rjae.springresearch.models.Session;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface SessionRepository extends JpaRepository<Session, Long> {
}
