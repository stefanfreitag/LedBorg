package de.freitag.stefan.ledborg.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Interfaces with LedBorg hardware.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
abstract class AbstractLedBorg implements LedBorg {

    /**
     * The {@link Logger} for this class.
     */
    private final static Logger LOG = LogManager.getLogger(AbstractLedBorg.class.getCanonicalName());

    /**
     * The currently shown/ set color.
     */
    private Color color;

    /**
     * Stores the blinking status.
     */
    private boolean blinking;

    private Timer blinkTimer;
    /**
     * The default blink rate.
     */
    private static final BlinkRate DEFAULT_RATE = BlinkRate.ONE_SECOND;

    /**
     * The currently set blink rate.
     */
    private BlinkRate blinkRate = DEFAULT_RATE;

    /**
     * Create a new {@link AbstractLedBorg}.
     * <ul>
     * <li>Blinking is disabled.</li>
     * <li>Default color is black</li></ul>
     */
    AbstractLedBorg() {
        this.blinking = false;
        this.color = new Color.Builder().create();
    }


    @Override
    public final Color getDisplayedColor() {
        return this.color;
    }


    @Override
    public void displayColor(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null");
        }
        this.color = color;
        LOG.info("Set displayed color to " + this.color);
    }

    @Override
    public final void brighter() {
        this.displayColor(this.color.brighter());
    }


    @Override
    public final void darker() {
        this.displayColor(this.color.darker());
    }

    @Override
    public void on() {
        LOG.info("Turning LedBorg on.");
    }

    @Override
    public void off() {
        LOG.info("Turning LedBorg off.");
    }


    @Override
    public final boolean isBlinking() {
        return this.blinking;
    }

    @Override
    public final void setBlinkRate(final BlinkRate blinkRate) {
        if (blinkRate == null) {
            throw new IllegalArgumentException("BlinkRate is null");
        }
        this.blinkRate = blinkRate;
        LOG.info("Set blinking rate to " + this.blinkRate);
    }

    @Override
    public final void blink(final boolean enable) {
        this.blinking = enable;
        if (enable) {
            blinkTimer = new Timer("Blink Timer");
            blinkTimer.schedule(new BlinkTask(), 0, this.blinkRate.getBlinkRate());
        } else {
            if (blinkTimer != null) {
                blinkTimer.cancel();
                blinkTimer = null;
            }
        }
    }

    private class BlinkTask extends TimerTask {

        private boolean toggle;

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            if (toggle) {
                displayColor(getDisplayedColor());
            } else {
                off();
            }
            toggle = !toggle;
        }
    }
}
