package de.freitag.stefan.ledborg.model;

import java.awt.*;

/**
 * LedBord interface.
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
public interface LedBorg {
    /**
     * Setup the communication with the LedBorg.
     */
    void setup();

    /**
     * Display the {@link Color} {@code color}.
     *
     * @param color The {@link Color} to display.
     * @throws IllegalArgumentException if {@code color} is {@code null}.
     */
    void displayColor(Color color);

    /**
     * Turn off the LedBorg by setting the displayed color to
     * {@code Color.Black}
     */
    void off();

    /**
     * Turn on the LedBorg by displaying the last set {@link Color}.
     */
    void on();

    /**
     * Return the displayed {@link Color}.
     *
     * @return The displayed {@link Color}.
     */
    Color getDisplayedColor();

    /**
     * Brightens up the displayed {@link Color} by one level.
     */
    void brighter();

    /**
     * Darkens the displayed {@link Color} by one level.
     */
    void darker();

    /**
     * Return if the LedBorg is blinking or not.
     *
     * @return {@code true} if the LedBorg is blinking, {@code false} otherwise.
     */
    boolean isBlinking();

    /**
     * Set the blink rate.
     *
     * @param blinkRate Blink rate in milliseconds
     * @throws IllegalArgumentException if {@code blinkRate} is {@code null}.
     */
    void setBlinkRate(BlinkRate blinkRate);

    void blink(boolean enable);
}
