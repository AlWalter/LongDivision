package com.myproject.division;

public class Division {
	private StringBuilder finalAnswer = new StringBuilder();
	private StringBuilder divResult = new StringBuilder();
	private StringBuilder nextDevidend;
	private String[] dividendDigits;
	private String beforeDividendSign = "_";
	private int offset = 1;
	private int dividendLength;
	private int intNextDevidend = 0;
	private int periodBegin = 0;
	private int periodEnd = 0;
	private int digitsAfterComma = 10;
	private boolean period = false;

	public String divideTwoInt(int devidend, int devider) {
		boolean isResultMinus = (devidend * devider < 0);
		devidend = Math.abs(devidend);
		devider = Math.abs(devider);

		if (devider == 0)
			throw new IllegalArgumentException("Zero devision. An integer cannot be divided by zero");

		dividendDigits = Integer.toString(devidend).split("");
		nextDevidend = new StringBuilder(devidend);

		if (devidend > devider) {
			countBeforeComma(devider);
			if (intNextDevidend != 0)
				countAfterComma(intNextDevidend, devider);
			else addLastRemainder(intNextDevidend);
		} else if (devidend < devider) {
			divResult.append("0");
			offset = +3;
			intNextDevidend = devidend;
			countAfterComma(devidend, devider);
		} else if (devidend == devider) {
			return "answer will be 1";
		}

		if (isResultMinus)
			divResult.insert(0, "-");
		makeHat(devidend, devider, dividendLength, divResult);
		return finalAnswer.toString();
	}

	private void countBeforeComma(int devider) {
		dividendLength = dividendDigits.length;
		for (int i = 0; i < dividendLength; i++) {
			nextDevidend.append(dividendDigits[i]);
			intNextDevidend = Integer.parseInt(nextDevidend.toString());
			offset++; //i + 2;
			if (intNextDevidend > devider) {
				int nextDigitOfAnswer = intNextDevidend / devider;
				int devReminder = intNextDevidend % devider;
				divResult.append(nextDigitOfAnswer);
				addDividend(offset, intNextDevidend);
				addMultiple(offset, nextDigitOfAnswer, devider);
				nextDevidend.replace(0, nextDevidend.length(), Integer.toString(devReminder));
			}
			intNextDevidend = Integer.parseInt(nextDevidend.toString());
		}
	}

	private void countAfterComma(int nextDevidend, int devider) {
		divResult.append(".");
		findPeriod(intNextDevidend, devider);
		if (period) digitsAfterComma = periodEnd + 1;
		for (int i = 0; i < digitsAfterComma; i++) {
			if (nextDevidend == 0) break;
			nextDevidend = nextDevidend * 10;
			int nextDigitOfAnswer = nextDevidend / devider;
			addDividend(offset, nextDevidend);
			addMultiple(offset, nextDigitOfAnswer, devider);
			offset++;
			divResult.append(nextDigitOfAnswer);
			if (nextDevidend >= devider) nextDevidend = nextDevidend % devider;
		}
		offset--;
		makeBrackets();
		addLastRemainder(nextDevidend);
	}

	private void findPeriod(int nextDevidend, int devider) {
		int[] arrayOfReminders = new int[10];
		for (int i = 0; i < 10; i++) {
			arrayOfReminders[i] = nextDevidend;
			nextDevidend = nextDevidend * 10;
			nextDevidend = nextDevidend % devider;
		}
		for (int i = 0; i < 10; i++) {
			if (period) break;
			int temp = arrayOfReminders[i];
			periodBegin = i;
			for (int j = i + 1; j < 10; j++) {
				if (temp == arrayOfReminders[j]) {
					if (temp != 0) period = true;
					periodBegin = i;
					periodEnd = j - 1;
					break;
				}
			}
		}
	}

	private void makeHat(int devidend, int divider, int format, StringBuilder devResult) {
		String hat1 = String.format("%3s", "_" + devidend) + "|" + divider;
		finalAnswer.replace(0, finalAnswer.indexOf("\n") + 1, "");
		String hat2 = String.format("%" + (format + 2 - finalAnswer.indexOf("\n") + devResult.length()) + "s",
				"|" + devResult.toString());
		finalAnswer.insert(finalAnswer.indexOf("\n"), hat2);
		finalAnswer.insert(0, "\n");
		finalAnswer.insert(0, hat1);
	}

	private void addDividend(int format, int dividend) {
		String tempDevidend = String.format("%" + format + "s", beforeDividendSign + Integer.toString(dividend));
		finalAnswer.append(tempDevidend).append("\n");
	}

	private void addMultiple(int format, int nextDigit, int divider) {
		int multiple = nextDigit * divider;
		String nextMultiply = String.format("%" + (format) + "d", multiple);
		finalAnswer.append(nextMultiply).append("\n");
		makeSeparation(format, multiple);
	}

	private void makeSeparation(int format, int digit) {
		StringBuilder separator = new StringBuilder();
		for (int i = 0; i < String.valueOf(Math.abs(digit)).length(); i++)
			separator.append("-");
		String separation = String.format("%" + format + "s", separator.toString());
		finalAnswer.append(separation).append("\n");
	}

	private void makeBrackets() {
		if (period) {
			divResult.insert(periodBegin + divResult.indexOf(".") + 1, "(").append(")");
		}
	}

	private void addLastRemainder(int lastDevidend) {
		beforeDividendSign = "";
		addDividend(offset, lastDevidend);
	}

}
