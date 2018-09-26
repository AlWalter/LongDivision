package com.myproject.division;

import static org.junit.Assert.*;

import com.myproject.division.Division;
import org.junit.*;

public class DivisionTest {

	private Division divisionWithPeriod;

	@Before
	public void setUp() {
		divisionWithPeriod = new Division();
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideTwoInt_divider0_IllegalArgumentException() {
		divisionWithPeriod.divideTwoInt(333, 0);
	}

	@Test
	public void divideTwoInt_dividendEqualsDivider_One() {
		assertEquals("answer will be 1", divisionWithPeriod.divideTwoInt(10, 10));
	}

	@Test
	public void divideTwoInt_dividendLessDivider_tenDigitsAfterComma() {
		String expected =
				" _5|98\n" +
						"  0|0.0510204081\n" +
						"  -\n" +
						"_500\n" +
						" 490\n" +
						" ---\n" +
						" _100\n" +
						"   98\n" +
						"   --\n" +
						"   _20\n" +
						"     0\n" +
						"     -\n" +
						"   _200\n" +
						"    196\n" +
						"    ---\n" +
						"     _40\n" +
						"       0\n" +
						"       -\n" +
						"     _400\n" +
						"      392\n" +
						"      ---\n" +
						"       _80\n" +
						"         0\n" +
						"         -\n" +
						"       _800\n" +
						"        784\n" +
						"        ---\n" +
						"        _160\n" +
						"          98\n" +
						"          --\n" +
						"          62\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(5, 98));
	}

	@Test
	public void divideTwoInt_dividendMoreDivider_zeroDigitsAfterComma() {
		String expected =
				"_7654|2\n" +
						" 6   |3827\n" +
						" -\n" +
						"_16\n" +
						" 16\n" +
						" --\n" +
						"  _5\n" +
						"   4\n" +
						"   -\n" +
						"  _14\n" +
						"   14\n" +
						"   --\n" +
						"    0\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(7654, 2));
	}

	@Test
	public void divideTwoInt_dividendMoreDivider_twoDigitsAfterComma() {
		String expected =
				"_115|4\n" +
						"  8 |28.75\n" +
						"  -\n" +
						" _35\n" +
						"  32\n" +
						"  --\n" +
						" _30\n" +
						"  28\n" +
						"  --\n" +
						"  _20\n" +
						"   20\n" +
						"   --\n" +
						"    0\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(115, 4));
	}

	@Test
	public void divideTwoInt_dividendMoreDivider_periodAfterComma() {
		String expected =
				"_1000|3\n" +
						"  9  |333.(3)\n" +
						"  -\n" +
						" _10\n" +
						"   9\n" +
						"   -\n" +
						"  _10\n" +
						"    9\n" +
						"    -\n" +
						"  _10\n" +
						"    9\n" +
						"    -\n" +
						"    1\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(1000, 3));
	}

	@Test
	public void divideTwoInt_dividendMoreDivider_longPeriod() {
		String expected =
				"_25|39\n" +
						"234|0.(641025)\n" +
						"---\n" +
						"_160\n" +
						" 156\n" +
						" ---\n" +
						"  _40\n" +
						"   39\n" +
						"   --\n" +
						"   _10\n" +
						"     0\n" +
						"     -\n" +
						"   _100\n" +
						"     78\n" +
						"     --\n" +
						"    _220\n" +
						"     195\n" +
						"     ---\n" +
						"      25\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(25, 39));
	}

	@Test
	public void divideTwoInt_dividendMoreDivider_periodTwoDigitsAfterComma() {
		String expected =
				" _7|12\n" +
						" 60|0.58(3)\n" +
						" --\n" +
						"_100\n" +
						"  96\n" +
						"  --\n" +
						"  _40\n" +
						"   36\n" +
						"   --\n" +
						"    4\n";
		assertEquals(expected, divisionWithPeriod.divideTwoInt(7, 12));
	}

}

