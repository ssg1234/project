package com.hexa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.BookingDetails;
import com.hexa.entity.FlightSchedule;

@Repository("mydao")
public class FlightDaoImpl implements FlightDao{

	@Autowired
	private SessionFactory sfac;
	
	@Override
	public int addBookingDetails(BookingDetails bdet) {
		Session sess= null;
			Transaction tx= null;
		try {
			sess= sfac.openSession();
			tx = sess.beginTransaction();
			sess.save(bdet);
			tx.commit();
			return 1;
			
		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
			if(tx!= null)
				tx.rollback();
			
		}finally {
			if(sess!= null) 
				sess.close();
		 }
		return 0;
	 }
	@Override
	public List<FlightSchedule> getSchedule() {
		Session sess = sfac.openSession();
		String hql = "from FlightSchedule f inner join fetch f.flight";
		Query qry = sess.createQuery(hql);
		List<FlightSchedule> lst=qry.list();
		return lst;
	}
	@Override
	public BookingDetails getDetails(int pnrno) {
		Session sess = sfac.openSession();
		String hql ="from BookingDetails b where pnrId=?";
		Query qry = sess.createQuery(hql);
		qry.setInteger(0, pnrno);
		BookingDetails b = (BookingDetails)qry.uniqueResult();
		
		return b;
	}
	@Override
	public int updateSeats(FlightSchedule fsch) {
		Session sess =sfac.openSession();
		Transaction tx = sess.beginTransaction();
	    sess.update(fsch);
		tx.commit();
		sess.close();
		return 1;
		
	}
	@Override
	public FlightSchedule getSeats(int schId) {
		System.out.println("Session factory " + sfac);
		Session sess = sfac.openSession();
		FlightSchedule fsch =sess.get(FlightSchedule.class, schId);
		sess.close();
		return fsch;
	}
	}


