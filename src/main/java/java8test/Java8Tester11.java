package java8test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by abdhesh on 15/07/17.
 */
public class Java8Tester11 {
    public static void main(String args[]) {
        Java8Tester11 java8tester = new Java8Tester11();
        java8tester.testAdjusters();
    }

    public void testAdjusters() {

        //Get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        //get the next tuesday
        LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);

        //get the second saturday of next month
        LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
        LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second Saturday on : " + secondSaturday);
    }
}