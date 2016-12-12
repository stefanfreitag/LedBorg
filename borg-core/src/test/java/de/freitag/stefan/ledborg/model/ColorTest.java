package de.freitag.stefan.ledborg.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Color}.
 */
public final class ColorTest {


    @Test
    public void constructorReturnsBlack() {
        final Color color = new Color();
        assertEquals(0.0f, color.getRed(), 0.0000f);
        assertEquals(0.0f, color.getGreen(), 0.0000f);
        assertEquals(0.0f, color.getBlue(), 0.0000f);
    }

    @Test
    public void constructorWithValuesReturnsExpectedColor() {
        final Color color = new Color(0.9f, 0.5f, 1.0f);
        assertEquals(0.9f, color.getRed(), 0.0000f);
        assertEquals(0.5f, color.getGreen(), 0.0000f);
        assertEquals(1.0f, color.getBlue(), 0.0000f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withBlueWithTooLowValueThrowsIllegalArgumentException() {
        new Color(0.0f,0.0f,-1.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withBlueWithTooHighValueThrowsIllegalArgumentException(){new Color(0.0f,0.0f,2.0f);}


    @Test(expected = IllegalArgumentException.class)
    public void withRedWithTooLowValueThrowsIllegalArgumentException() {
        new Color(-1.0f,0.0f,0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withRedWithTooHighValueThrowsIllegalArgumentException() {
        new Color(2.0f,0.0f,0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withGreenWithTooLowValueThrowsIllegalArgumentException() {
        new Color(0.0f,-1.0f,0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withGreenWithTooHighValueThrowsIllegalArgumentException() {
        new Color(0.0f,2.0f,0.0f);
    }

}