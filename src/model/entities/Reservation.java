package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	// estamos colocando como static para que não seja instanciado um novo a cada aplicação
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Reservation() {
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	//long é um int maior
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // aqui nós convertemos o valor diff que estava em milisegundos, para dias
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		} if (!checkout.after(checkin)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout) + ", "  + duration() + " nights.";
	}
	
	
}
