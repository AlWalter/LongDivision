package main.java.com.myproject.division;

public class Division {

	private StringBuilder finalAnswer = new StringBuilder();

	public String divideTwoInt(int devidend, int devider) {
		boolean isResultMinus = (devidend * devider < 0);
		devidend = Math.abs(devidend);
		devider = Math.abs(devider);
		if (devider == 0)
			throw new IllegalArgumentException("Zero devision. An integer cannot be divided by zero");
		if (devidend < devider)
			return "Devidend is less than devisor. The answer will be 0";

		String[] devidendDigits = Integer.toString(devidend).split("");
		StringBuilder devResult = new StringBuilder();
		StringBuilder nextDevidend = new StringBuilder(devidend);
		int intNextDevidend;
		int devidendLength = devidendDigits.length;
		for (int i = 0; i < devidendLength; i++) {
			nextDevidend.append(devidendDigits[i]);
			intNextDevidend = Integer.parseInt(nextDevidend.toString());
			int offset = i + 2;
			if (intNextDevidend > devider) {
				int nextDigitOfAnswer = intNextDevidend / devider;
				int devReminder = intNextDevidend % devider;
				devResult.append(nextDigitOfAnswer);
				addDividend(offset, intNextDevidend);
				addMultiple(offset, nextDigitOfAnswer, devider);
				nextDevidend.replace(0, nextDevidend.length(), Integer.toString(devReminder));
			}
			if (i == (devidendLength - 1)) {
				String lastReminder = String.format("%" + offset + "s", nextDevidend.toString());
				finalAnswer.append(lastReminder);
			}
		}
		if (isResultMinus)
			devResult.insert(0, "-");
		makeHat(devidend, devider, devidendLength, devResult);
		return finalAnswer.toString();
	}

	private void makeHat(int devidend, int devider, int format, StringBuilder devResult) {
		String hat1 = "_" + devidend + "|" + devider;
		finalAnswer.replace(0, finalAnswer.indexOf("\n") + 1, "");
		String hat2 = String.format("%" + (format + 2 - finalAnswer.indexOf("\n") + devResult.length()) + "s",
				"|" + devResult.toString());
		finalAnswer.insert(finalAnswer.indexOf("\n"), hat2);
		finalAnswer.insert(0, "\n");
		finalAnswer.insert(0, hat1);
	}

	private void addDividend(int format, int dividend) {
		String tempDevidend = String.format("%" + format + "s", "_" + Integer.toString(dividend));
		finalAnswer.append(tempDevidend).append("\n");
	}

	private void addMultiple(int format, int nextDigit, int devider) {
		int multiple = nextDigit * devider;
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
}
