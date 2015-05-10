package de.freitag.stefan.ledbord;

import com.pi4j.io.gpio.RaspiPin;
import de.freitag.stefan.ledborg.PinLayout;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link PinLayout}.
 */
public final class PinLayoutTest {

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullRedThrowsIllegalArgumentException() {
        PinLayout.create(null, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullGreenThrowsIllegalArgumentException() {
        PinLayout.create(RaspiPin.GPIO_00, null, RaspiPin.GPIO_03);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullBlueThrowsIllegalArgumentException() {
        PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, null);
    }

    @Test
    public void getRedReturnsExpectedValue() {
        final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        assertEquals(RaspiPin.GPIO_00, layout.getRed());
    }

    @Test
    public void getGreenReturnsExpectedValue() {
        final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        assertEquals(RaspiPin.GPIO_02, layout.getGreen());
    }

    @Test
    public void getBlueReturnsExpectedValue() {
        final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        assertEquals(RaspiPin.GPIO_03, layout.getBlue());
    }

}