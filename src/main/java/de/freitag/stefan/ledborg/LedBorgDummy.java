package de.freitag.stefan.ledborg;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * LedBorg dummy implementation.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
public final class LedBorgDummy implements LedBorg {


    /**
     * The currently shown/ set color.
     */
    private Color color;

    /**
     * Stores the blinking status.
     */
    private boolean isBlinking;

    private Timer blinkTimer;
    /**
     * The default blink rate.
     */
    private BlinkRate DEFAULT_RATE = BlinkRate.ONE_SECOND;

    /**
     * The currently set blink rate.
     */
    private BlinkRate blinkRate = DEFAULT_RATE;

    /**
     * Initialize the {@link LedBorgDummy}.
     */
    public LedBorgDummy() {
        this.isBlinking = false;
        this.color = Color.BLACK;
    }

    /**
     * Initialize the LedBorg with a pin layout.
     *
     * @param layout a {@code PinLayout}. Must not be {@code null}.
     */
    public LedBorgDummy(final PinLayout layout) {
        super();
        Objects.requireNonNull(layout, "Pin layout not allowed to be null.");
    }

    /**
     * Return the {@link Logger} for this class.
     *
     * @return The {@link Logger} for this class.
     */
    private static Logger getLogger() {
        return LogManager.getLogger(LedBorgDummy.class.getCanonicalName());
    }

    @Override
    public void setup() {
        this.off();
    }

    @Override
    public void displayColor(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null");
        }
        this.color = color;
    }

    @Override
    public void off() {
        //Empty method
    }

    @Override
    public Color getDisplayedColor() {
        return this.color;
    }


    @Override
    public void brighter() {
        this.displayColor(this.color.brighter());
    }

    @Override
    public void darker() {
        this.displayColor(this.color.darker());
    }


    @Override
    public boolean isBlinking() {
        return this.isBlinking;
    }

    @Override
    public void setBlinkRate(BlinkRate blinkRate) {
        if (blinkRate == null) {
            throw new IllegalArgumentException("BlinkRate is null");
        }
        getLogger().info("Set blink rate to " + blinkRate.getBlinkRate() + " ms.");
        this.blinkRate = blinkRate;
    }

    @Override
    public void blink(final boolean enable) {
        this.isBlinking = enable;
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

        private boolean toggle = false;

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            if (toggle) {
                LedBorgDummy.this.displayColor(LedBorgDummy.this.getDisplayedColor());
            } else {
                LedBorgDummy.this.off();
            }
            toggle = !toggle;
        }
    }
}
