package de.freitag.stefan.ledborg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link LedBorgImpl}.
 *
 * @author Stefan Freitag
 */
final class LedBorgImplTest {

  @Test
  void getDisplayedColorInitiallyReturnsExpectedValue() {
    final LedBorgImpl ledBorg = new LedBorgImpl();
    assertEquals(new Color(), ledBorg.getDisplayedColor());
  }
}
