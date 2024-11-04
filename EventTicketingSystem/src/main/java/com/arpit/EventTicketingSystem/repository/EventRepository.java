package com.arpit.EventTicketingSystem.repository;

import com.arpit.EventTicketingSystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
