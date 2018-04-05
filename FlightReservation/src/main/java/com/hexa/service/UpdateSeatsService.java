package com.hexa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.dao.FlightDao;
import com.hexa.entity.BookingDetails;
import com.hexa.entity.FlightSchedule;
@Service("myser")

public class UpdateSeatsService implements FSer{
	Logger logger = LoggerFactory.getLogger("empapp");
	@Autowired
	FlightDao dao;
	@Override
	@Transactional(readOnly=false)
	public int updateSeat(int schId, int seatsApplied,BookingDetails bdet) {
		FlightSchedule fd =dao.getSeats(schId);
	
		if(fd.getSeats()>seatsApplied) {
			int res=dao.addBookingDetails(bdet);
			logger.debug("row inserted" + bdet.getPnrId());
			if(res>0) {
			fd.setSeats(fd.getSeats()-seatsApplied);
			dao.updateSeats(fd);
			logger.debug("no of seats updated" +fd.getSeats());
			}
			
		}
		
		return 1;
	}
	
	
    
}
