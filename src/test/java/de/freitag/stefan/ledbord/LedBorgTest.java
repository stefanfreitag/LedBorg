package de.freitag.stefan.ledbord;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link de.freitag.stefan.ledbord.LedBorg}.
 */
public final class LedBorgTest {

    @Test
    public void getDisplayedColorInitiallyReturnsExpectedValue() {
        final LedBorg ledBorg = new LedBorg();
        assertEquals(Color.BLACK, ledBorg.getDisplayedColor());
    }
}