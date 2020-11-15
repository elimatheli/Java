import static org.junit.Assert.*;
import org.junit.Test;
import date.Date;
import date.Month;

public class DateTest {

	@Test
	public void tomorrowWhenOrdinaryCase() {
		Date d = new Date(11, Month.february, 2020);
		Date e = new Date(12, Month.february, 2020);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void tomorrowWhenEndOfMonth() {
		Date d = new Date(31, Month.january, 2020);
		Date e = new Date(1, Month.february, 2020);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void tomorrowWhenEndOfYear() {
		Date d = new Date(31, Month.december, 2020);
		Date e = new Date(1, Month.january, 2021);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void tomorrowWhenEndOfFebruaryAndYearIsLeap() {
		Date d = new Date(28, Month.february,2020);
		Date e = new Date(29, Month.february, 2020);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void tomorrowWhenEndOfFebruaryAndYearIsNotLeap() {
		Date d = new Date(28, Month.february, 2021);
		Date e = new Date(1, Month.march, 2021);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void nDaysLaterInSameMonth(){
		Date d = new Date(1,Month.january,2020);
		Date e = new Date(11, Month.january, 2020);
		assertEquals(d.nDaysLater(10), e);
	}

	@Test
	public void nDaysLaterOverMonths(){
		Date d = new Date(31,Month.march,2020);
		Date e = new Date(1, Month.june, 2020);
		assertEquals(d.nDaysLater(62), e);
	}

	@Test
	public void nDaysLaterAfterOneYear(){
		Date d = new Date(1,Month.january,2021);
		Date e = new Date(1, Month.january, 2022);
		assertEquals(d.nDaysLater(365), e);
	}

	@Test (expected=IllegalArgumentException.class)
	public void nDaysLaterThrowsExceptionWhenNbDaysIsNegative(){
		Date d = new Date(1,Month.january,2020);
		d.nDaysLater(-55);
	}

// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DateTest.class);
}


}
