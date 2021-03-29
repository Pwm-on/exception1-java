package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Main55 {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number:");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date date_checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date date_checkout = sdf.parse(sc.next());
		if (!date_checkout.after(date_checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else {
			Reservation reservation = new Reservation (number,date_checkin,date_checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			date_checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			date_checkout = sdf.parse(sc.next());
			Date now = new Date();
			if (date_checkout.before(now) || date_checkin.before(now)){
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!date_checkout.after(date_checkin)) {
					System.out.println("Error in reservation: Check-out date must be after check-in date!");
				}
			else {
				reservation.updateDates(date_checkin, date_checkout);
				System.out.println(reservation);
			}
			
		}
	}

}
