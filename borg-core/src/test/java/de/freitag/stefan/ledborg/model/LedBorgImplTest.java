package de.freitag.stefan.ledborg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link LedBorgImpl}.
 * @author Stefan Freitag
 */
final class LedBorgImplTest {

    @Test
    void getDisplayedColorInitiallyReturnsExpectedValue() {
        final LedBorgImpl ledBorg = new LedBorgImpl();
        assertEquals(new Color(), ledBorg.getDisplayedColor());
    }
}