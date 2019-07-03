package de.freitag.stefan.ledborg.utils;

import de.freitag.stefan.ledborg.model.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Test class for {@link Color}. */
final class ColorTest {

  @Test
  void constructorReturnsBlack() {
    final Color color = new Color();
    Assertions.assertEquals(0.0f, color.getRed(), 0.000001f);
    Assertions.assertEquals(0.0f, color.getGreen(), 0.000001f);
    Assertions.assertEquals(0.0f, color.getBlue(), 0.000001f);
  }

  @Test
  void constructorWithValuesReturnsExpectedColor() {
    final Color color = new Color(0.9f, 0.5f, 1.0f);
    Assertions.assertEquals(0.9f, color.getRed(), 0.000001f);
    Assertions.assertEquals(0.5f, color.getGreen(), 0.000001f);
    Assertions.assertEquals(1.0f, color.getBlue(), 0.000001f);
  }

  @Test
  void withBlueWithTooLowValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 0.0f, -1.0f));
  }

  @Test
  void withBlueWithTooHighValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 0.0f, 2.0f));
  }

  @Test
  void withRedWithTooLowValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(-1.0f, 0.0f, 0.0f));
  }

  @Test
  void withRedWithTooHighValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(2.0f, 0.0f, 0.0f));
  }

  @Test
  void withGreenWithTooLowValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, -1.0f, 0.0f));
  }

  @Test
  void withGreenWithTooHighValueThrowsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Color(0.0f, 2.0f, 0.0f));
  }
}
