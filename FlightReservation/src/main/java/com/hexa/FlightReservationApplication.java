package com.hexa;

import java.util.Random;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.hexa.entity.BookingDetails;
import com.hexa.entity.CustomerDetails;
import com.hexa.entity.FlightSchedule;
import com.hexa.service.FSer;

@SpringBootApplication
@EntityScan("com.hexa.entity")
public class FlightReservationApplication implements CommandLineRunner{
	
	@Autowired
	private EntityManagerFactory emf;

	@Autowired
	FSer fs;
	
	@Bean
	public SessionFactory getSessionFactory() {
		return emf.unwrap(SessionFactory.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FlightReservationApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		BookingDetails b =new BookingDetails();
		FlightSchedule fd= new FlightSchedule();
		fd.setSchId(911);
		CustomerDetails cd =new CustomerDetails();
		cd.setCustId(1002);
		Random r = new Random();
		int bid=r.nextInt(1000);
		b.setPnrId(bid);
		b.setPassengers(2);
	    b.setSchedule(fd);
	    b.setCustomer(cd);
		System.out.println(fs.updateSeat(3003, 3,b));
		
	}
}
