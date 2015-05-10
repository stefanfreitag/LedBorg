package de.freitag.stefan.ledbord;

import de.freitag.stefan.ledborg.LedBorg;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link LedBorg}.
 */
public final class LedBorgTest {

    @Test
    public void getDisplayedColorInitiallyReturnsExpectedValue() {
        final LedBorg ledBorg = new LedBorg();
        assertEquals(Color.BLACK, ledBorg.getDisplayedColor());
    }
}