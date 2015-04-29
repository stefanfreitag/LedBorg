package de.freitag.stefan.ledbord;

import com.pi4j.io.gpio.Pin;

public final class PinLayout {

    private final Pin red;
    private final Pin green;
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

    public Pin getRed() {
        return this.red;
    }

    public Pin getGreen() {
        return this.green;
    }

    public Pin getBlue() {
        return this.blue;
    }

}