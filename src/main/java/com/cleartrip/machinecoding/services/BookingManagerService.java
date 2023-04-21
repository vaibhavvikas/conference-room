package com.cleartrip.machinecoding.services;

import com.cleartrip.machinecoding.Database.Database;
import com.cleartrip.machinecoding.models.Booking;
import com.cleartrip.machinecoding.utils.Helper;

import java.util.*;

public class BookingManagerService {
    Database database = Database.getDatabase();
    AvailablityService availablityService = new AvailablityService();
    public String addBooking(Integer startTime, Integer endTime, String buildingId, String floorId, String roomId){
        String roomBookingsId = buildingId + " " + floorId + " " +roomId;

        if (availablityService.isAvailable(roomBookingsId, startTime, endTime)) {
            Booking booking = new Booking(UUID.randomUUID().toString(), startTime, endTime);
            database.getBookings().put(booking.getBookingId(), booking);
            database.getRoomBookings().get(roomBookingsId).add(new ArrayList<>(Arrays.asList(startTime, endTime)));
            return "Booking successfully created";
        }
        return "Error creating Booking";
    }


    public void getRooms(){
        if (database.getRoomBookings().size() == 0) {
            System.out.println("Error Occured");
        }

        database.getRoomBookings().forEach((key, value) -> {
            StringBuilder availabilities = new StringBuilder("");
            availabilities.append(key);

            if (value == null || value.size() == 0){
                availabilities.append(" [{1:24}]");
            } else {
                ArrayList<Integer> firstElement = value.get(0);
                if (firstElement.get(0) > 1) {
                    availabilities.append(" [{1:"+ firstElement.get(0)+"}");
                }


                for (int i = 1; i < value.size(); i++) {
                    if (value.get(i-1).get(1) != value.get(i).get(1)){
                        availabilities.append(" {"+value.get(i-1).get(1)+":"+value.get(i).get(1)+"}");
                    }
                }

                if (value.get(value.size()-1).get(1) != 24){
                    availabilities.append(" {" + value.get(value.size()-1).get(1) + ":24}}");
                } else {
                    availabilities.append("]");
                }
            }

            System.out.println(availabilities.toString());
        });
    }

    public void listBookings(){
        HashMap bookings = database.getRoomBookings();

        bookings.forEach((key, value) -> {
            System.out.println(key + " " + value.toString());
        });
    }
}
