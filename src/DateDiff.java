import java.util.GregorianCalendar;

public class DateDiff {
    public static void main(String[] av) {
        /** The date at the end of the last century */
        java.util.Date d1 = new GregorianCalendar(2018, 7, 06, 23, 59).getTime();

        /** Today's date */
        java.util.Date today = new java.util.Date();

        // Get msec from each, and subtract.
        long diff = today.getTime() - d1.getTime();
        System.out.println(d1);
        System.out.println(today);

        System.out.println("The 21st century (up to " + today + ") is "
                + (diff / (1000 * 60 )) + " days old.");
    }
}
