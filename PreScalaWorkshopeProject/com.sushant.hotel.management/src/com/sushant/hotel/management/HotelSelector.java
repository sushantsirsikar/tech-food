package com.sushant.hotel.management;

import com.sushant.hotel.data.Hotel;

/**
 * This interface need to be implemented by client to provide selection
 * criteria.
 * 
 * @author sushant
 */
public interface HotelSelector {

	/**
	 * return {@link Hotel} depending on selection criteria
	 * 
	 * @param inputObj
	 * @return {@link Hotel} which satisfies selection criteria otherwise return
	 *         null
	 */
	public Hotel findHotel(Object inputObj);

}