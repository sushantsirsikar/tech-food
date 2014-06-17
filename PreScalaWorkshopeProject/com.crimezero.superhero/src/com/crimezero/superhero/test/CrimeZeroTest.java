package com.crimezero.superhero.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crimezero.superhero.data.Repository;
import com.crimezero.superhero.service.InputParser;
import com.crimezero.superhero.service.SuperHeroFinder;

public class CrimeZeroTest {

	private static Repository repository;

	@BeforeClass
	public static void setUp() {
		repository = new Repository();
	}

	@Test
	public void testInputParser() {
		String code = InputParser.getSuperHeroCode("0 4855");
		Assert.assertEquals("4855", code);

		code = InputParser.getSuperHeroCode("04855");
		Assert.assertNull(code);
	}

	@Test
	public void testSuperHeroFinder() {
		SuperHeroFinder superHeroFinder = new SuperHeroFinder();
		String superHero = superHeroFinder.findSuperHero("0 22782462637422",
				repository);
		Assert.assertEquals("CAPTAINAMERICA", superHero);

		superHero = superHeroFinder.findSuperHero("0 228626", repository);
		Assert.assertEquals("BATMAN", superHero);

		superHero = superHeroFinder.findSuperHero("0 4855", repository);
		Assert.assertEquals("HULK", superHero);

		superHero = superHeroFinder.findSuperHero("0 78737626", repository);
		Assert.assertEquals("SUPERMAN", superHero);

		superHero = superHeroFinder.findSuperHero("0 8467", repository);
		Assert.assertEquals("THOR", superHero);

	}

}
