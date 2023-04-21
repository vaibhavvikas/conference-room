package com.cleartrip.machinecoding.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Booking {
    private final String bookingId;
    private final Integer startTime;
    private final Integer endTime;
}
