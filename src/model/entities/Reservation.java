package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	// estamos colocando como static para que não seja instanciado um novo a cada aplicação
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {								// com o trhows DomainException estamos propagando a exceção para outra classe tratá-la
			throw new DomainException("Check-out date must be after check-in date");
		}
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
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates"); // aqui em vez de retornar uma string, estamos lançando uma exceção
		} if (!checkout.after(checkin)) {												    // pesquisar sobre classes de exceções
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout) + ", "  + duration() + " nights.";
	}
	
	
}
