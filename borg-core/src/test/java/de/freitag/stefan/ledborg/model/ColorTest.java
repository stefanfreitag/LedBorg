package de.freitag.stefan.ledborg.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Color}.
 */
public final class ColorTest {
    private final Color.Builder builder = new Color.Builder();

    @Test
    public void createReturnsBlack() {
        final Color color = builder.create();
        assertEquals(0.0f, color.getRed(), 0.0000f);
        assertEquals(0.0f, color.getGreen(), 0.0000f);
        assertEquals(0.0f, color.getBlue(), 0.0000f);
    }

    @Test
    public void createReturnsExpectedColor() {
        final Color color = builder.withRed(0.9f).withBlue(1.0f).withGreen(0.5f).create();
        assertEquals(0.9f, color.getRed(), 0.0000f);
        assertEquals(0.5f, color.getGreen(), 0.0000f);
        assertEquals(1.0f, color.getBlue(), 0.0000f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withBlueWithTooLowValueThrowsIllegalArgumentException() {
        builder.withBlue(-1.0f).create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withBlueWithTooHighValueThrowsIllegalArgumentException() {
        builder.withBlue(2.0f).create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withRedWithTooLowValueThrowsIllegalArgumentException() {
        builder.withRed(-1.0f).create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withRedWithTooHighValueThrowsIllegalArgumentException() {
        builder.withRed(2.0f).create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withGreenWithTooLowValueThrowsIllegalArgumentException() {
        builder.withGreen(-1.0f).create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void withGreenWithTooHighValueThrowsIllegalArgumentException() {
        builder.withGreen(2.0f).create();
    }

}