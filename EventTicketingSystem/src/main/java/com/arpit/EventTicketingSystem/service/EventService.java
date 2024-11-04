package com.arpit.EventTicketingSystem.service;

import com.arpit.EventTicketingSystem.dto.EventDto;
import com.arpit.EventTicketingSystem.entities.Event;
import com.arpit.EventTicketingSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {


    @Autowired
    private EventRepository er;

    public List<Event> getEvents() {
        return er.findAll();
    }

    public Event getEvent(Long id) {
        return er.findById(id).orElse(null);
    }

    public Event addEvent(EventDto eventDto) {
         Event event = new Event();
        return getEvent(eventDto, event);
    }

    public Event updateEvent(Long id, EventDto eventDto) {

        Optional<Event> op = er.findById(id);
        if(op.isPresent()) {
            Event event = op.get();
            return getEvent(eventDto, event);
        }
        else {
            return null;
        }
    }

    private Event getEvent(EventDto eventDto, Event event) {
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        event.setVenue(eventDto.getVenue());
        event.setDate(eventDto.getDate());
        event.setTime(eventDto.getTime());
        event.setSeatsAvailable(eventDto.getSeatsAvailable());
        event.setPrice(eventDto.getPrice());
        System.out.println("Event Processed");
        return er.save(event);
    }

    public String deleteEvent(Long id) {
        Optional<Event> op = er.findById(id);
        if(op.isPresent()) {
            er.delete(op.get());
            return "Event Deleted Successfully";
        }
        else{
            return "Event Not Found";
        }
    }

}
