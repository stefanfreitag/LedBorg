package de.freitag.stefan.ledborg.demo;

import de.freitag.stefan.ledborg.BlinkRate;
import de.freitag.stefan.ledborg.LedBorg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public final class LedBorgDemo {

    /**
     * Entry point of the application.
     *
     * @param args Arguments to the application.
     */
    public static void main(final String[] args) {
        final LedBorg ledborg = new LedBorg();
        ledborg.setup();
        ledborg.displayColor(Color.BLUE);
        ledborg.setBlinkRate(BlinkRate.TWO_SECONDS);
        ledborg.blink(true);
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                getLogger().error("Interrupted exception:", exception);
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Return the {@link Logger} for this class.
     *
     * @return The {@link Logger} for this class.
     */
    private static Logger getLogger() {
        return LogManager.getLogger(LedBorgDemo.class.getCanonicalName());
    }
}
