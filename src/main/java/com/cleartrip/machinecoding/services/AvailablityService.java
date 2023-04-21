package com.cleartrip.machinecoding.services;

import com.cleartrip.machinecoding.Database.Database;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.*;

public class AvailablityService {
    Database database = Database.getDatabase();

    public Boolean isAvailable(String roomBookingId, Integer startTime, Integer endTime) {
        if (startTime >= 24 || endTime > 24 || startTime < 1 || endTime <= 1 || startTime >= endTime){
            return false;
        }

        // While creating a room we are creating a map with empty List. Not having the key simply means
        // there is no toom
        if (!database.getRoomBookings().containsKey(roomBookingId)) {
            return false;
        }

//        sortBookings(roomBookingId);
        List<ArrayList<Integer>> currRoomBookings = database.getRoomBookings().get(roomBookingId);

        for (int i=0; i < currRoomBookings.size(); i++){
            if (startTime >= currRoomBookings.get(i).get(0) && startTime <= currRoomBookings.get(i).get(1)){
                return false;
            }

            if (endTime >= currRoomBookings.get(i).get(0) && endTime <= currRoomBookings.get(i).get(1)){
                return false;
            }
        }

        return true;
    }
}
