package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Main {

	public static void main(String[] args) {

		Scanner ent = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = ent.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(ent.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(ent.next(), fmt);

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);

			System.out.println("\n\nEnter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(ent.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(ent.next(), fmt);

			reservation.updateDates(checkIn, checkOut);

			System.out.print("Reservation: " + reservation);
		} catch (DomainExceptions e) {
			System.err.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.err.println("Unexpected error");
		}


		ent.close();
	}

}
