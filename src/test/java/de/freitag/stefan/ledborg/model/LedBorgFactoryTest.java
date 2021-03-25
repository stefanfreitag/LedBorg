package de.freitag.stefan.ledborg.model;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link LedBorgFactory}.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
final class LedBorgFactoryTest {

  @Test
  void getLedBorgBasedOnType() {
    LedBorg ledBorg = LedBorgFactory.get(LedBorgFactory.TYPE.REAL);
    System.out.println(ledBorg);

    LedBorg ledBorg2 = LedBorgFactory.get(LedBorgFactory.TYPE.DUMMY);
    System.out.println(ledBorg2);
  }
}
