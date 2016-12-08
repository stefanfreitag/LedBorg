package de.freitag.stefan.ledborg.demo;

import de.freitag.stefan.ledborg.model.BlinkRate;
import de.freitag.stefan.ledborg.model.Color;
import de.freitag.stefan.ledborg.model.LedBorg;
import de.freitag.stefan.ledborg.model.LedBorgFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demo Application.
 * LedBord is blinking in an interval of two seconds.
 * Used color is red.
 */
public final class LedBorgDemo {

    /**
     * The {@link Logger} for this class.
     */
    private final static Logger LOG = LogManager.getLogger(LedBorgDemo.class.getCanonicalName());

    private LedBorgDemo(){
        //empty method
    }
    /**
     * Entry point of the application.
     *
     * @param args Arguments to the application.
     */
    public static void main(final String[] args) {
        final LedBorg ledborg = LedBorgFactory.get(LedBorgFactory.TYPE.REAL);
        Color.Builder builder = new Color.Builder();
        ledborg.setup();
        ledborg.setBlinkRate(BlinkRate.TWO_SECONDS);
        ledborg.blink(true);

        ledborg.displayColor(builder.withRed(1.0f).create());
        Runtime.getRuntime().addShutdownHook(new Thread(ledborg::off));

        while (true) {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException exception) {
                LOG.error("Interrupted exception:", exception);
                Thread.currentThread().interrupt();
            }
        }
    }

}
