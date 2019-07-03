package de.freitag.stefan.ledborg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pi4j.io.gpio.RaspiPin;
import org.junit.jupiter.api.Test;

/** Test class for {@link de.freitag.stefan.ledborg.model.PinLayout}. */
final class PinLayoutTest {

  @Test
  void createWithNullRedThrowsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () -> PinLayout.builder().red(null).green(RaspiPin.GPIO_02).blue(RaspiPin.GPIO_03).build());
  }

  @Test
  void createWithNullGreenThrowsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () -> PinLayout.builder().red(RaspiPin.GPIO_00).green(null).blue(RaspiPin.GPIO_03));
  }

  @Test
  void createWithNullBlueThrowsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () -> PinLayout.builder().red(RaspiPin.GPIO_00).green(RaspiPin.GPIO_02).blue(null).build());
  }

  @Test
  void getRedReturnsExpectedValue() {
    final PinLayout layout =
        PinLayout.builder()
            .red(RaspiPin.GPIO_00)
            .green(RaspiPin.GPIO_02)
            .blue(RaspiPin.GPIO_03)
            .build();
    assertEquals(RaspiPin.GPIO_00, layout.getRed());
  }

  @Test
  void getGreenReturnsExpectedValue() {
    final PinLayout layout =
        PinLayout.builder()
            .red(RaspiPin.GPIO_00)
            .green(RaspiPin.GPIO_02)
            .blue(RaspiPin.GPIO_03)
            .build();
    assertEquals(RaspiPin.GPIO_02, layout.getGreen());
  }

  @Test
  void getBlueReturnsExpectedValue() {
    final PinLayout layout =
        PinLayout.builder()
            .red(RaspiPin.GPIO_00)
            .green(RaspiPin.GPIO_02)
            .blue(RaspiPin.GPIO_03)
            .build();
    assertEquals(RaspiPin.GPIO_03, layout.getBlue());
  }
}
