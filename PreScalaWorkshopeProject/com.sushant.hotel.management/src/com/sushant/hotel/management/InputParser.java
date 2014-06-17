/**
 * 
 */
package com.sushant.hotel.management;

import java.util.ArrayList;
import java.util.List;

import com.sushant.hotel.Utils.LoggerUtils;
import com.sushant.hotel.Utils.Messages;
import com.sushant.hotel.data.CustomerType;
import com.sushant.hotel.data.Input;

/**
 * This class parse the input and return the {@link Input} model
 * 
 * @author sushant
 */
public class InputParser {

	private static final String INVALID_INPUT_MSG = Messages.getString("InputParser.InvalidInputFormatErrorMsg"); //$NON-NLS-1$

	private static final String PATTERN = "[:,]"; //$NON-NLS-1$

	private static final List<String> weekendDays = new ArrayList<String>();
	private static final List<String> weekDays = new ArrayList<String>();

	// Need to store all the valid inputs for future validation
	static {
		weekendDays.add("sat"); //$NON-NLS-1$
		weekendDays.add("sun"); //$NON-NLS-1$
		weekDays.add("mon"); //$NON-NLS-1$
		weekDays.add("tues"); //$NON-NLS-1$
		weekDays.add("wed"); //$NON-NLS-1$
		weekDays.add("thur"); //$NON-NLS-1$
		weekDays.add("fri"); //$NON-NLS-1$
	}

	public static Input parse(String inputStr) {
		if (inputStr == null || inputStr.isEmpty()) {
			LoggerUtils.logError(Messages.getString("InputParser.InputNullEmptyErrorMsg")); //$NON-NLS-1$
			return null;
		}

		String[] parts = inputStr.split(PATTERN);

		if (parts.length < 2) {
			LoggerUtils.logError(INVALID_INPUT_MSG);
			return null;
		}
		// first part should be customer type

		String type = parts[0];
		CustomerType customerType = null;
		try {
			customerType = CustomerType.valueOf(type.trim().toUpperCase());
		} catch (IllegalArgumentException e) {
			LoggerUtils.logError(String.format(
					Messages.getString("InputParser.CustomerNotValidErrorMsg"), type)); //$NON-NLS-1$
			return null;
		}

		if (customerType == null) {
			return null;
		}

		Input input = new Input();
		input.setCustomerType(customerType);

		for (int i = 1; i < parts.length; i++) {
			String date = parts[i].trim();
			int startIndex = date.indexOf("("); //$NON-NLS-1$
			int endIndex = date.indexOf(")"); //$NON-NLS-1$
			if (startIndex < 0 || endIndex < 0 || startIndex > endIndex) {
				LoggerUtils.logError(INVALID_INPUT_MSG);
				return null;
			}

			String day = date.substring(startIndex + 1, endIndex);
			if (day.isEmpty()) {
				LoggerUtils.logError(INVALID_INPUT_MSG);
				return null;
			}
			if (isWeekday(day)) {
				input.incrementWeekdays();
			} else if (isWeekend(day)) {
				input.incrementWeekends();
			} else {
				LoggerUtils.logError(INVALID_INPUT_MSG);
				return null;
			}
		}
		return input;
	}

	private static boolean isWeekend(String day) {
		// make input lower case to compare with valid input set
		day = day.toLowerCase();

		if (weekendDays.contains(day)) {
			return true;
		}
		return false;
	}

	private static boolean isWeekday(String day) {
		// make input lower case to compare with valid input set
		day = day.toLowerCase();

		if (weekDays.contains(day)) {
			return true;
		}
		return false;
	}

}
