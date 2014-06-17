/**
 * 
 */
package com.crimezero.superhero.service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Set;

import com.crimezero.superhero.data.Repository;
import com.crimezero.superhero.utils.LoggerUtils;
import com.crimezero.superhero.utils.Messages;

/**
 * This class provides method to find the super hero form repository.
 * 
 * @author sushant
 */
public class SuperHeroFinder {

	private static final String RESULT_MSG = Messages.getString("SuperHeroFinder.ResultMsg"); //$NON-NLS-1$
	private static final String ERROR_MSG_NO_SUPERHERO = Messages.getString("SuperHeroFinder.NoHeroFoundErrorMsg"); //$NON-NLS-1$

	/**
	 * Find the super hero for passed input from given repository
	 * 
	 * @param input
	 *            super hero code
	 * @param repository
	 *            {@link Repository} which store list of heroes.
	 * @return name of super hero which maps to passed code.
	 */
	public String findSuperHero(String input, Repository repository) {
		String heroCode = InputParser.getSuperHeroCode(input);
		if (heroCode == null) {
			return null;
		}

		int codeLenght = heroCode.length();
		Map<Integer, Set<String>> heroesMap = repository
				.getLengthBasedHeroesMap();
		if (!heroesMap.containsKey(codeLenght)) {
			LoggerUtils.logError(MessageFormat.format(ERROR_MSG_NO_SUPERHERO,
					heroCode));
			return null;
		}

		Set<String> heroNames = heroesMap.get(codeLenght);

		SuperHeroMatcherService service = SuperHeroMatcherService
				.getCodeMatcherService();
		String superHeroName = service.matchCode(heroCode, heroNames);
		if (superHeroName == null) {
			LoggerUtils.logError(MessageFormat.format(ERROR_MSG_NO_SUPERHERO,
					heroCode));
		} else {
			//wow.. found hero
			LoggerUtils.logInfo(MessageFormat.format(RESULT_MSG, heroCode,
					superHeroName));
		}
		return superHeroName;
	}
}
