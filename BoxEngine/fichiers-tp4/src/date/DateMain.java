// Main class for class Date
package date;
import date.Date;
import date.Month;

public class DateMain{
  public static void main(String[] args){
    Date d = new Date(1,Month.january,2000);
    System.out.println("My date of birth is :");
    Date birthday = d.nDaysLater(12);
    System.out.println(birthday);
    Date to = new Date(18,Month.february,2020);
    Date today = new Date(to);
    System.out.println("Today is the "+today.getDay()+"th of "+today.getMonth()+" "+today.getYear()+".");
    Date tomorrow = today.tomorrow();
    System.out.println("Tomorrow will be the "+tomorrow.getDay()+"th of "+tomorrow.getMonth()+" "+tomorrow.getYear()+".");
    System.out.println("So my age in days is : "+today.differenceInDays(birthday));
    System.out.println("Is my birthday before today ? : "+birthday.isBefore(today));
    System.out.println("Then \"today if after my birthday\" is "+birthday.isAfter(today));
    System.out.println("So it is obvious that my birthday and today isn't the same day. Is it the same day ? : "+birthday.equals(today));
    System.out.println("Can you print today please ? : ");
    System.out.println(today.toString());
    System.out.println("Thank you!");
    System.out.println("Please remind me, is this year leap ? : "+Date.isLeap(today.getYear()));
  }
}
