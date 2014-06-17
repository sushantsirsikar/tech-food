/**
 * 
 */
package com.sushant.hotel.test;

import org.junit.Assert;
import org.junit.Test;

import com.sushant.hotel.data.Hotel;
import com.sushant.hotel.data.Input;
import com.sushant.hotel.management.CheapHotelSelector;
import com.sushant.hotel.management.HotelSelector;
import com.sushant.hotel.management.InputParser;

/**
 * Test class to test the possible use cases
 * @author sushant
 * 
 */
public class ChecpHotelSelectorTester {

	@Test
	public void testInputParser() {
		Input input = InputParser
				.parse("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		Assert.assertNotNull(input);

		input = InputParser
				.parse("Regular: 16Mar2009(mond), 17Mar2009(tuses), 18Mar2009(weds)");
		Assert.assertNull(input);

		input = InputParser.parse("Regular:");
		Assert.assertNull(input);

		input = InputParser
				.parse("Regu: 16Mar2009(mond), 17Mar2009(tuses), 18Mar2009(weds)");
		Assert.assertNull(input);

	}

	@Test
	public void testCheapHotelSelector() {
		HotelSelector selector = new CheapHotelSelector();
		Hotel chepestHotel = selector
				.findHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		Assert.assertNotNull(chepestHotel);
		Assert.assertEquals("Lackwood", chepestHotel.getName());
		chepestHotel = selector
				.findHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
		Assert.assertEquals("Bridgewood", chepestHotel.getName());
		chepestHotel = selector
				.findHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
		Assert.assertEquals("Ridgewood", chepestHotel.getName());
		chepestHotel = selector
				.findHotel("Regular: 16Mar2009(mond), 17Mar2009(tuses), 18Mar2009(weds)");
		Assert.assertNull(chepestHotel);
	}
}
