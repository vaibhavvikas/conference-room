package com.cleartrip.machinecoding.services;

import com.cleartrip.machinecoding.Database.Database;
import com.cleartrip.machinecoding.models.Building;
import com.cleartrip.machinecoding.models.Floor;

import java.util.ArrayList;

public class BuildingManagerService {
    Database database = Database.getDatabase();

    public String addBuilding(String buildingId) {
        String errorString = "Error creating Building "+ buildingId +" in the system.";
        if (database.getBuildings().containsKey(buildingId)) {
            return errorString;
        }
        Building building = new Building(buildingId);
        database.getBuildings().put(buildingId, building);
        return "Created building " + buildingId + " in the system.";
    }

    public String addFloor(String buildingId, String floorId) {
        String errorString = "Error creating Floor"+ floorId +" in the system.";
        if (!database.getBuildings().containsKey(buildingId)) {
            return errorString;
        }

        Building building = database.getBuildings().get(buildingId);
        if (building.getFloors().containsKey(floorId)) {
            return errorString;
        }

        building.addFloor(floorId);
        database.getBuildings().put(buildingId, building);
        return "Created Floor " + floorId + " in the building " + buildingId + " in the system.";
    }

    public String addRoom(String buildingId, String floorId, String roomId) {
        String errorString = "Error creating room in the system.";
        if (!database.getBuildings().containsKey(buildingId)) {
            return errorString;
        }

        Building building = database.getBuildings().get(buildingId);
        if (!building.getFloors().containsKey(floorId)) {
            return errorString;
        }

        Floor floor = building.getFloors().get(floorId);
        if (floor.getRooms().containsKey(roomId)){
            return errorString;
        }

        floor.addRoom(roomId);
        building.getFloors().put(floorId, floor);
        database.getBuildings().put(buildingId, building);

        String roomBookingId = buildingId + " " + floorId + " " + roomId;
        database.getRoomBookings().put(roomBookingId, new ArrayList<>());

        return "Created Room " + roomId + " in the floor " + floorId + " in the building " + buildingId + " in the system.";
    }
}
