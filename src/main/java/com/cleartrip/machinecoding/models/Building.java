package com.cleartrip.machinecoding.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;


@Getter
public class Building {
    private final String buildingId;
    private HashMap<String, Floor> floors = new HashMap<>();

    public Building(String buildingId) {
        this.buildingId = buildingId;
    }
    public void addFloor(String floorId) {
        floors.putIfAbsent(floorId, new Floor(floorId));
    }
}
