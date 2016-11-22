package de.freitag.stefan.ledborg.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link LedBorgImpl}.
 * @author Stefan Freitag
 */
public final class LedBorgImplTest {

    @Test
    public void getDisplayedColorInitiallyReturnsExpectedValue() {
        final LedBorgImpl ledBorg = new LedBorgImpl();
        assertEquals(Color.BLACK, ledBorg.getDisplayedColor());
    }
}