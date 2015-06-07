package de.freitag.stefan.ledborg;

/**
 * Allowed blink rates in milliseconds.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
public enum BlinkRate {
    /**
     * 1 second.
     */
    ONE_SECOND(1000l),
    /**
     * Two seconds.
     */
    TWO_SECONDS(2000l),
    /**
     * Five seconds.
     */
    FIVE_SECONDS(5000l);

    /**
     * Blink rate in milliseconds.
     */
    private long blinkRate;

    /**
     * Create a new {@link BlinkRate}.
     *
     * @param blinkRate The blink rate in milliseconds.
     */
    BlinkRate(final long blinkRate) {
        this.blinkRate = blinkRate;
    }

    public long getBlinkRate() {
        return this.blinkRate;
    }
}
