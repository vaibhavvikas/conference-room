package com.cleartrip.machinecoding.Database;

import com.cleartrip.machinecoding.models.Booking;
import com.cleartrip.machinecoding.models.Building;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Database {
    private final HashMap<String, Building> buildings = new HashMap<>();
    private final HashMap<String, Booking> bookings = new HashMap<>();
    private final HashMap<String, List<ArrayList<Integer>>> roomBookings = new HashMap<>();

    private Database(){}
    private static Database database = null;

    public static Database getDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

}
