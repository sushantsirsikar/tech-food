/**
 * 
 */
package com.sushant.hotel.data;

/**
 * @author sushant
 * 
 */
public class Input {

	private CustomerType customerType;

	private int numberOfWeekdays = 0;

	private int numberOfWeekends = 0;

	/**
	 * @return the customerType
	 */
	public CustomerType getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType
	 *            the customerType to set
	 */
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	/**
	 * @return the numberOfWeekdays
	 */
	public int getNumberOfWeekdays() {
		return numberOfWeekdays;
	}

	/**
	 * @param numberOfWeekdays
	 *            the numberOfWeekdays to set
	 */
	public void setNumberOfWeekdays(int numberOfWeekdays) {
		this.numberOfWeekdays = numberOfWeekdays;
	}

	/**
	 * @return the numberOfWeekends
	 */
	public int getNumberOfWeekends() {
		return numberOfWeekends;
	}

	/**
	 * @param numberOfWeekends
	 *            the numberOfWeekends to set
	 */
	public void setNumberOfWeekends(int numberOfWeekends) {
		this.numberOfWeekends = numberOfWeekends;
	}

	/**
	 * increment weekends by 1
	 */
	public void incrementWeekends() {
		numberOfWeekends++;
	}

	/**
	 * increment weekdays by 1
	 * 
	 */
	public void incrementWeekdays() {
		numberOfWeekdays++;
	}
}
