package de.freitag.stefan.ledborg.model;

/**
 * Allowed blink rates in milliseconds.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
public enum BlinkRate {
    /**
     * One second.
     */
    ONE_SECOND(1000L),
    /**
     * Two seconds.
     */
    TWO_SECONDS(2000L),
    /**
     * Five seconds.
     */
    FIVE_SECONDS(5000L);

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

    @java.lang.Override
    public java.lang.String toString() {
        return "BlinkRate: " + this.blinkRate + " ms";
    }
}
