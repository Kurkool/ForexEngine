package com.exchange;

import java.math.*;
import java.util.*;

import com.exchange.model.*;

/**
 * @author Devskiller
 */
class Calculator {

	private final ForexEngine forexEngine;

	Calculator(ForexEngine forexEngine) {
		this.forexEngine = forexEngine;
	}

	/**
	 * Calculates exchanged currency rate.
	 *
	 * @param amount    amount to convert
	 * @param convertTo currency to convert to
	 * @return exchanged amount
	 */
	Money exchange(Money amount, Currency convertTo) throws RateUnavailableException {
		throw new UnsupportedOperationException("Please, implement me");
	}

}
