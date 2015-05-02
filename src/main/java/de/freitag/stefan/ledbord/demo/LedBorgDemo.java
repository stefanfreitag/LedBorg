package de.freitag.stefan.ledbord.demo;

import de.freitag.stefan.ledbord.LedBorg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public final class LedBorgDemo {
    /**
     * Time between two color changes in seconds.
     */
    private static final long DELAY_IN_SECONDS = 3;
    /**
     * Colors to display.
     */
    private static Color[] colors = new Color[]{Color.blue, Color.CYAN, Color.MAGENTA, Color.orange, Color.YELLOW, Color.RED};

    /**
     * Entry point of the application.
     *
     * @param args Arguments to the application.
     */
    public static void main(final String[] args) {
        final LedBorg ledborg = new LedBorg();
        ledborg.setup();
        int i = 0;
        while (true) {
            final Color color = colors[i++ % colors.length];
            getLogger().info("Setting color " + color);
            ledborg.displayColor(color);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(DELAY_IN_SECONDS));
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
