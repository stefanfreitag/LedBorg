package de.freitag.stefan.ledborg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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