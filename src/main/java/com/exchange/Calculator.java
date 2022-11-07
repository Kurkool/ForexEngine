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
//		throw new UnsupportedOperationException("Please, implement me");

		System.out.println(forexEngine.getExchangeRate(new Pair("USD","JPY")));
		System.out.println(amount.getCurrency() + " : " + amount.getAmount());
		System.out.println(convertTo.getCurrencyCode());
		BigDecimal rate,convertedAmount;

		try {
			rate = forexEngine.getExchangeRate(new Pair(String.valueOf(amount.getCurrency()), convertTo.getCurrencyCode()));
			convertedAmount = amount.getAmount().multiply(rate);
		}catch (RateUnavailableException e) {
			rate = forexEngine.getExchangeRate(new Pair(String.valueOf(convertTo.getCurrencyCode()), String.valueOf(amount.getCurrency())));
			convertedAmount = amount.getAmount().divide(rate);
		}

		System.out.println("convertedAmount : "+convertedAmount);
		return new Money(convertedAmount, Currency.getInstance(convertTo.getCurrencyCode()));
	}

}
