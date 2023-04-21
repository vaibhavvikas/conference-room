package com.cleartrip.machinecoding;

import com.cleartrip.machinecoding.Database.Database;
import com.cleartrip.machinecoding.services.AvailablityService;
import com.cleartrip.machinecoding.services.BookingManagerService;
import com.cleartrip.machinecoding.services.BuildingManagerService;


public class MachinecodingApplication {

	public static void main(String[] args) {
		Database database = Database.getDatabase();
		BuildingManagerService buildingManagerService = new BuildingManagerService();
		AvailablityService availablityService = new AvailablityService();
		BookingManagerService bookingManagerService = new BookingManagerService();

		System.out.println(buildingManagerService.addBuilding("b1"));
		System.out.println(buildingManagerService.addBuilding("b2"));

		System.out.println(buildingManagerService.addBuilding("b1"));
		System.out.println(buildingManagerService.addBuilding("b2"));

		System.out.println(buildingManagerService.addFloor("b2", "2"));
		System.out.println(buildingManagerService.addRoom("b2", "2", "c1"));

		System.out.println(buildingManagerService.addFloor("b2", "1"));
		System.out.println(buildingManagerService.addRoom("b2", "1", "c3"));

		// Will throw error
		System.out.println(buildingManagerService.addRoom("b1", "2", "c1"));

		System.out.println(buildingManagerService.addFloor("b1", "3"));
		System.out.println(buildingManagerService.addRoom("b1", "3", "c1"));

		bookingManagerService.getRooms();

		System.out.println(bookingManagerService.addBooking(12, 20, "b1", "3", "c1"));

		bookingManagerService.getRooms();

		// Give error
		System.out.println(bookingManagerService.addBooking(12, 20, "b1", "3", "c1"));

		// Give error
		System.out.println(bookingManagerService.addBooking(14, 22, "b1", "3", "c1"));

		System.out.println(bookingManagerService.addBooking(2, 8, "b2", "1", "c3"));
		System.out.println(bookingManagerService.addBooking(1, 4, "b1", "3", "c1"));

		bookingManagerService.listBookings();
	}
}
