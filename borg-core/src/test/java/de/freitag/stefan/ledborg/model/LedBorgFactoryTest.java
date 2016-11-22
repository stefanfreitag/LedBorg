package de.freitag.stefan.ledborg.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link LedBorgFactory}.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
public final class LedBorgFactoryTest {

    @Test(expected = NullPointerException.class)
    public void createWithNullThrowsNullPointerException() {
        LedBorgFactory.get(null);
    }

    @Test
    public void getReturnsExpectedInstanceForDummy() {
        assertThat(LedBorgFactory.get(LedBorgFactory.TYPE.DUMMY), instanceOf(LedBorgDummy.class));
    }

}