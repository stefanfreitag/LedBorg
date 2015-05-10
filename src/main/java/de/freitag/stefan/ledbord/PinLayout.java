package de.freitag.stefan.ledbord;

import com.pi4j.io.gpio.Pin;

public final class PinLayout {

    /**
     * The {@link Pin} the red LED is connected to.
     */
    private final Pin red;
    /**
     * The {@link Pin} the green LED is connected to.
     */
    private final Pin green;
    /**
     * The {@link Pin} the blue LED is connected to.
     */
    private final Pin blue;

    /**
     * Create a new {@code PinLayout}.
     *
     * @param red   The GPIO pin the red LED is connected to.
     * @param green The GPIO pin the green LED is connected to.
     * @param blue  The GPIO pin the blue LED is connected to.
     */
    private PinLayout(final Pin red, final Pin green, final Pin blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Create a new {@code PinLayout}.
     *
     * @param red   The GPIO pin the red LED is connected to.
     * @param green The GPIO pin the green LED is connected to.
     * @param blue  The GPIO pin the blue LED is connected to.
     * @return A new {@code PinLayout}.
     *
     */
    public static PinLayout create(final Pin red, final Pin green, final Pin blue) {
        if (red == null) {
            throw new IllegalArgumentException("Red Pin is null");
        }
        if (green == null) {
            throw new IllegalArgumentException("Green Pin is null");
        }
        if (blue == null) {
            throw new IllegalArgumentException("Blue Pin is null");
        }

        return new PinLayout(red, green, blue);
    }

    /**
     * The {@link Pin} the red LED is connected to.
     *
     * @return The {@link Pin} the red LED is connected to.
     */
    public Pin getRed() {
        return this.red;
    }

    /**
     * The {@link Pin} the green LED is connected to.
     * @return The {@link Pin} the green LED is connected to.
     */
    public Pin getGreen() {
        return this.green;
    }

    /**
     * The {@link Pin} the blue LED is connected to.
     * @return The {@link Pin} the blue LED is connected to.
     */
    public Pin getBlue() {
        return this.blue;
    }

}
