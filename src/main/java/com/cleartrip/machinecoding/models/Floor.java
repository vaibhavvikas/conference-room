package com.cleartrip.machinecoding.models;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Floor {
    private final String floorId;
    private HashMap<String, Room> rooms = new HashMap<>();

    public Floor(String floorId) {
        this.floorId = floorId;
    }
    public void addRoom(String roomId) {
        rooms.putIfAbsent(roomId, new Room(roomId));
    }
}
