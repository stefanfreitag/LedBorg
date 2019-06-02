package de.freitag.stefan.ledborg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pi4j.io.gpio.RaspiPin;
import org.junit.jupiter.api.Test;

/** Test class for {@link PinLayout}. */
final class PinLayoutTest {

  @Test
  void createWithNullRedThrowsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PinLayout.create(null, RaspiPin.GPIO_02, RaspiPin.GPIO_03));
  }

  @Test
  void createWithNullGreenThrowsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PinLayout.create(RaspiPin.GPIO_00, null, RaspiPin.GPIO_03));
  }

  @Test
  void createWithNullBlueThrowsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, null));
  }

  @Test
  void getRedReturnsExpectedValue() {
    final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    assertEquals(RaspiPin.GPIO_00, layout.getRed());
  }

  @Test
  void getGreenReturnsExpectedValue() {
    final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    assertEquals(RaspiPin.GPIO_02, layout.getGreen());
  }

  @Test
  void getBlueReturnsExpectedValue() {
    final PinLayout layout = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    assertEquals(RaspiPin.GPIO_03, layout.getBlue());
  }
}
