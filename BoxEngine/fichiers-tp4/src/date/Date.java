package date;
import date.Month;

public class Date  {

	private int day;
	private Month month;
	private int year;

	/**
	* creates a date with the day, the month and the year
	* @param day the day you want to set
	* @param month the month you want to set
	* @param year the year you want to set
	*/
	public Date(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	* creates another same day with a day
	* @param date the date you want to copy
	*/
	public Date(Date date) {
		this(date.getDay() , date.getMonth() , date.getYear()) ;
	}

	/**
	* returns the day of the date
	* @return the day of the date
	*/
	public int getDay() {return day;} // ou return this.day ;
	/**
	* returns the month of the date
	* @return the month of the date
	*/
	public Month getMonth() {return month;}
	/**
	* returns the year of the date
	* @return the year of the date
	*/
	public int getYear() {return year;}

	/** returns the date corresponding to  tomorrow for this date
	* @return the date corresponding to  tomorrow for this date
	*/
	public Date tomorrow() {
		if (this.day < this.month.nbDays(this.year)) {
			return new Date(this.day + 1, this.month, this.year) ;
		} else {
			if (this.month.equals(Month.december)) {
				return new Date(1, Month.january, year + 1 );
			} else {
			  return new Date(1, this.month.next(), year);
		  }
		}
	}

	/** computes the date reached in <code>nbDays</code> after this
	* @param nbDays the number of days between this and wanted date
	* @return the date reached in <code>nbDays</code> after this
	* @exception IllegalArgumentException if <code>nbDays</code> is negative
	*/
	public Date nDaysLater(int nbDays) {
		if (nbDays < 0) throw new IllegalArgumentException("argument should be positive") ;
		Date result = this ;
		for (int i = 0 ; i < nbDays; i++) {
			result = result.tomorrow();
		}
		return result;
	}

	/** returns the number of days between this and given date, it is
	* negative if <code>this</code> is before <code>d</code>
	* @param d the date to be compared with
	* @return  the number of days between this and given date, it is
	* negative if this is before <code>d</code>
	*/
	public int differenceInDays(Date d) {
    	 Date negative = new Date(this) ;
    	 Date positive  = new Date(d) ;
    	 int nbd = 0 ;
    	 while(!negative.equals(d) && !positive.equals(this)) {
    		 negative = negative.tomorrow() ;
    		 positive  = positive.tomorrow() ;
    		 nbd++ ;
    	 }
    	 if (negative.equals(d)) return -nbd ; else return nbd ;
	}

	/** returns whether this date is older than a given date
	* @param d the date to be compared with
	* @return true iff this date is older than date d
	*/
	public boolean isBefore(Date d) {
    	 return this.differenceInDays(d) < 0 ;
	}

	/** returns whether this date is newer than a given date
	* @param d the date to be compared with
	* @return true iff this date is newer than date d
	*/
	public boolean isAfter(Date d) {
    	 return this.differenceInDays(d) > 0 ;
	}

	@Override // on indique qu'on change le comportement par défaut de equals mais que la spéc. est la même
	public boolean equals(Object o) {
		if (! (o instanceof Date)) return false ;
		Date other = (Date) o;
		return this.day == other.day &&
				this.month.equals(other.month) && // ou this.month == other.month car Month est un enum
				this.year == other.year ;
	}

	@Override
	public String toString() {
		return this.day + " " + this.month + " " + this.year;
	}

	/** computes whether year is a leap year or not
	* @param year the year to check
	* @return <tt>true</tt> if and only if year is a leap year
	*/
	public static boolean isLeap(int year) {
		return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
	}//la méthode est statique car elle ne dépend pas d'une instance de date particulière
}
