package de.freitag.stefan.ledborg.model;

import com.pi4j.io.gpio.Pin;

import java.util.Objects;

/**
 * Pin layout used as part of the {@link LedBorgImpl}.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
final class PinLayout {

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
    static PinLayout create(final Pin red, final Pin green, final Pin blue) {
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
    Pin getRed() {
        return this.red;
    }

    /**
     * The {@link Pin} the green LED is connected to.
     * @return The {@link Pin} the green LED is connected to.
     */
    Pin getGreen() {
        return this.green;
    }

    /**
     * The {@link Pin} the blue LED is connected to.
     * @return The {@link Pin} the blue LED is connected to.
     */
    Pin getBlue() {
        return this.blue;
    }

    @Override
    public String toString() {
        return "PinLayout{" +
                "blue=" + blue +
                ", green=" + green +
                ", red=" + red +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PinLayout pinLayout = (PinLayout) o;
        return Objects.equals(getRed(), pinLayout.getRed()) &&
                Objects.equals(getGreen(), pinLayout.getGreen()) &&
                Objects.equals(getBlue(), pinLayout.getBlue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRed(), getGreen(), getBlue());
    }
}
