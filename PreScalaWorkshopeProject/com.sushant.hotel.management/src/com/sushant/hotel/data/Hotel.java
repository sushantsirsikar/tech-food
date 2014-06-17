/**
 * 
 */
package com.sushant.hotel.data;

/**
 * Place holder for all the available hotel.
 * 
 * @author sushant
 */
public class Hotel {
	private String name;
	private int rating;
	private int regularWeekendRate;
	private int regularWeekdayRate;
	private int rewardsWeekendRate;
	private int rewardsWeekdayRate;

	/**
	 * @param name
	 *            Name of the hotel
	 * @param rating
	 *            Rating of the hotel
	 * @param regularWeekendRate
	 *            weekend rate for regular customer
	 * @param regularWeekdayRate
	 *            weekday rate for regular customer
	 * @param rewardsWeekendRate
	 *            weekend rate for reward customer
	 * @param rewardsWeekdayRate
	 *            weekday rate for reward customer
	 */
	public Hotel(String name, int rating, int regularWeekendRate,
			int regularWeekdayRate, int rewardsWeekendRate,
			int rewardsWeekdayRate) {
		super();
		this.name = name;
		this.rating = rating;
		this.regularWeekendRate = regularWeekendRate;
		this.regularWeekdayRate = regularWeekdayRate;
		this.rewardsWeekendRate = rewardsWeekendRate;
		this.rewardsWeekdayRate = rewardsWeekdayRate;
	}

	/**
	 * Upon passing customer type and package type, method will return specific
	 * rate.
	 * 
	 * @param customerType
	 * @param packageType
	 * @return
	 */
	public int getRate(CustomerType customerType, PackageType packageType) {
		switch (customerType) {
		case REGULAR:
			switch (packageType) {
			case WEEKDAY:
				return regularWeekdayRate;
			case WEEKEND:
				return regularWeekendRate;
			default:
				System.out.println("Wrong option");
			}
			break;
		case REWARDS:
			switch (packageType) {
			case WEEKDAY:
				return rewardsWeekdayRate;
			case WEEKEND:
				return rewardsWeekendRate;
			default:
				System.out.println("Wrong option");
			}
			break;
		}
		return -1;
	}

	/**
	 * @return hotel name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public int getRating() {
		return rating;
	}
}
