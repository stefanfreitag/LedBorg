package de.freitag.stefan.ledborg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Test class for {@link Color}. */
final class ColorTest {

  @Test
  void constructorReturnsBlack() {
    final Color color = new Color();
    assertEquals(0.0f, color.getRed(), 0.000001f);
    assertEquals(0.0f, color.getGreen(), 0.000001f);
    assertEquals(0.0f, color.getBlue(), 0.000001f);
  }

  @Test
  void constructorWithValuesReturnsExpectedColor() {
    final Color color = new Color(0.9f, 0.5f, 1.0f);
    assertEquals(0.9f, color.getRed(), 0.000001f);
    assertEquals(0.5f, color.getGreen(), 0.000001f);
    assertEquals(1.0f, color.getBlue(), 0.000001f);
  }

  @Test
  void withBlueWithTooLowValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 0.0f, -1.0f));
  }

  @Test
  void withBlueWithTooHighValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 0.0f, 2.0f));
  }

  @Test
  void withRedWithTooLowValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(-1.0f, 0.0f, 0.0f));
  }

  @Test
  void withRedWithTooHighValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(2.0f, 0.0f, 0.0f));
  }

  @Test
  void withGreenWithTooLowValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, -1.0f, 0.0f));
  }

  @Test
  void withGreenWithTooHighValueThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 2.0f, 0.0f));
  }
}
