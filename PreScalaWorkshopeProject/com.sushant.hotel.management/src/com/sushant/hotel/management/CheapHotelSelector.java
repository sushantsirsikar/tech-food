/**
 * 
 */
package com.sushant.hotel.management;

import java.util.ArrayList;
import java.util.List;

import com.sushant.hotel.Utils.LoggerUtils;
import com.sushant.hotel.Utils.Messages;
import com.sushant.hotel.data.Hotel;
import com.sushant.hotel.data.Input;
import com.sushant.hotel.data.PackageType;

/**
 * Concrete implementation of {@link HotelSelector} based on cost. This will
 * return cheapest available hotel from provided option
 * 
 * @author sushant
 */
public class CheapHotelSelector implements HotelSelector {

	List<Hotel> hotels = new ArrayList<Hotel>();

	public CheapHotelSelector() {
		init();
	}

	/**
	 * Initialise hotels
	 */
	private void init() {
		addHotel(new Hotel("Lackwood", 3, 90, 110, 80, 80)); //$NON-NLS-1$
		addHotel(new Hotel("Bridgewood", 4, 60, 160, 50, 110)); //$NON-NLS-1$
		addHotel(new Hotel("Ridgewood", 5, 150, 220, 40, 100)); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sushant.hotel.management.HotelSelector#findHotel(java.lang.String)
	 */
	@Override
	public Hotel findHotel(Object inputObj) {
		if (!(inputObj instanceof String)) {
			LoggerUtils.logError(String.format(Messages.getString("CheapHotelSelector.InputTypeErrorMsg"))); //$NON-NLS-1$
			return null;
		}
		String inputStr = (String) inputObj;
		Hotel cheapHotel = null;
		int cheapRate = 0;
		Input input = InputParser.parse(inputStr);
		if (input == null) {
			LoggerUtils.logError(String.format(Messages.getString("CheapHotelSelector.InvalidInputErrorMsg"), //$NON-NLS-1$
					inputStr));
			return null;
		}
		for (Hotel hotel : hotels) {
			int total = getWeekendValue(input, hotel)
					+ getWeekdayValue(input, hotel);
			if (cheapHotel == null) {
				cheapRate = total;
				cheapHotel = hotel;
			} else if (total < cheapRate) {
				cheapRate = total;
				cheapHotel = hotel;
			} else if (total == cheapRate) {
				cheapHotel = cheapHotel.getRating() < hotel.getRating() ? hotel
						: cheapHotel;
			}
		}

		if (cheapHotel != null) {
			LoggerUtils.logInfo(String.format(Messages.getString("CheapHotelSelector.CheapestHotelInfoMsg"), //$NON-NLS-1$
					cheapHotel.getName()));
		}
		return cheapHotel;
	}

	private int getWeekdayValue(Input input, Hotel hotel) {
		int noOfWeekdays = input.getNumberOfWeekdays();
		if (noOfWeekdays == 0) {
			return 0;
		}
		int rate = hotel.getRate(input.getCustomerType(), PackageType.WEEKDAY);
		return noOfWeekdays * rate;
	}

	private int getWeekendValue(Input input, Hotel hotel) {
		int noOfWeekends = input.getNumberOfWeekends();
		if (noOfWeekends == 0) {
			return 0;
		}
		int rate = hotel.getRate(input.getCustomerType(), PackageType.WEEKEND);
		return noOfWeekends * rate;
	}

	/**
	 * @param hotel
	 */
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
}
