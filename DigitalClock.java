package Task1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {
    public static void main(String[] args) {
        while (true) {
            // Get current time
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String formattedTime = sdf.format(now);

            // Clear the console (for better visualization, works on some IDEs and terminals)
            System.out.print("\033[H\033[2J");

            // Display the digital clock
            System.out.println("Digital Clock: " + formattedTime);

            try {
                // Pause for one second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}