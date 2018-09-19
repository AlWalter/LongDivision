package test.java.com.myproject.division;

import static org.junit.Assert.*;

import main.java.com.myproject.division.Division;
import org.junit.*;

public class DivisionTest {

    private Division division;

    @Before
    public void setUp() {
        division = new Division();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void divideTwoInt_divider0_IllegalArgumentException() {
       division.divideTwoInt(333, 0);
    }

    @Test
    public void divideTwoInt_dividend0_Result0() {
        assertEquals("Devidend is less than devisor. The answer will be 0",
                division.divideTwoInt(0,1));
    }
    
    @Test
    public void divideTwoInt_dividendLessThanDevider_Result0() {
        assertEquals("Devidend is less than devisor. The answer will be 0",
                division.divideTwoInt(10,100));
    }
    
    @Test
    public void divideTwoInt_dividendLessZero_ResultMinus() {
    	String expected = 
    			"_54321|22\n" + 
    			" 44   |-2469\n" + 
    			" --\n" + 
    			"_103\n" + 
    			"  88\n" + 
    			"  --\n" + 
    			" _152\n" + 
    			"  132\n" + 
    			"  ---\n" + 
    			"  _201\n" + 
    			"   198\n" + 
    			"   ---\n" + 
    			"     3";
        assertEquals(expected,division.divideTwoInt(-54321,22));
    }
    
    @Test
    public void divideTwoInt_dividerLessZero_ResultMinus() {
    	String expected = 
    			"_577|22\n" + 
    			" 44 |-26\n" + 
    			" --\n" + 
    			"_137\n" + 
    			" 132\n" + 
    			" ---\n" + 
    			"   5";
        assertEquals(expected,division.divideTwoInt(577,-22));
    }
    
    @Test
    public void divideTwoInt_dividerAndDividendLessZero_ResultPlus() {
    	String expected = 
    			"_577|22\n" + 
    			" 44 |26\n" + 
    			" --\n" + 
    			"_137\n" + 
    			" 132\n" + 
    			" ---\n" + 
    			"   5";
        assertEquals(expected,division.divideTwoInt(577,22));
    }
    
    @Test
    public void divideTwoInt_dividendMoreThanDeviderBothPlus_Result() {
    	String expected = 
    			"_54321|22\n" + 
    	    	" 44   |2469\n" + 
    	    	" --\n" + 
    	    	"_103\n" + 
    	    	"  88\n" + 
    	    	"  --\n" + 
    	    	" _152\n" + 
    	    	"  132\n" + 
    	    	"  ---\n" + 
    	    	"  _201\n" + 
    	    	"   198\n" + 
    	    	"   ---\n" + 
    	    	"     3";
        assertEquals(expected,division.divideTwoInt(54321,22));
    }
}

