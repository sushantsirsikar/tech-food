/**
 * 
 */
package com.crimezero.superhero.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Repository stores list of super heros. While adding new super hero, it stores length<->name map of super hero.
 * This is helpful in finding super hero of particular name length/size. 
 * @author sushant
 */
public class Repository {

	Map<Integer, Set<String>> lengthBasedHeroesMap = new HashMap<Integer, Set<String>>();

	public Repository() {
		init();
	}

	/**
	 * Initialize super heroes 
	 */
	private void init() {
		addSuperHero("SUPERMAN");
		addSuperHero("THOR");
		addSuperHero("ROBIN");
		addSuperHero("IRONMAN");
		addSuperHero("GHOSTRIDER");
		addSuperHero("CAPTAINAMERICA");
		addSuperHero("FLASH");
		addSuperHero("WOLVERINE");
		addSuperHero("BATMAN");
		addSuperHero("HULK");
		addSuperHero("BLADE");
		addSuperHero("PHANTOM");
		addSuperHero("SPIDERMAN");
		addSuperHero("BLACKWINDOW");
		addSuperHero("HELLBY");
		addSuperHero("PUNISHER");
	}

	/**
	 * Add super hero to length<->name map
	 * @param name
	 */
	public void addSuperHero(String name) {
		if (name != null && !name.isEmpty()) {
			int length = name.length();
			if (lengthBasedHeroesMap.containsKey(length)) {
				Set<String> nameSet = lengthBasedHeroesMap.get(length);
				nameSet.add(name);
			} else {
				Set<String> nameSet = new HashSet<String>();
				nameSet.add(name);
				lengthBasedHeroesMap.put(length, nameSet);
			}
		}
	}

	/**
	 * @return length<->name {@link Map}
	 */
	public Map<Integer, Set<String>> getLengthBasedHeroesMap() {
		return lengthBasedHeroesMap;
	}
}
