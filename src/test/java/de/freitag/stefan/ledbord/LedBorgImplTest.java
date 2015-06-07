package de.freitag.stefan.ledbord;

import de.freitag.stefan.ledborg.LedBorgImpl;
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