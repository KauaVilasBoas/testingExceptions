package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) {

		Scanner ent = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = ent.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(ent.next(), fmt);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(ent.next(), fmt);

		if (!checkOut.isAfter(checkIn)) {
			System.err.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);

			System.out.println("\n\nEnter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(ent.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(ent.next(), fmt);

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.err.println("Error in reservation: " + error);
			} else {
				System.out.print("Reservation: " + reservation);
			}
		}
		ent.close();
	}

}
