package com.arpit.EventTicketingSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {

    private Long Id;
    private String name;
    private String description;
    private String venue;
    private String date;
    private String time;
    private int seatsAvailable;
    private Double price;

}
