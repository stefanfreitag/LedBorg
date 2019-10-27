package de.freitag.stefan.ledborg.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link LedBorgFactory}.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
final class LedBorgFactoryTest {

  @Test
  void createWithNullThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> LedBorgFactory.get(null));
  }
}
