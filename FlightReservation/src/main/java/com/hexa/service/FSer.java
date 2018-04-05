package com.hexa.service;

import com.hexa.entity.BookingDetails;

public interface FSer {
    public int updateSeat(int schId,int seatsApplied,BookingDetails bdet);
}
