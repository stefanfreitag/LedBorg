package de.freitag.stefan.ledborg.model;

import java.util.Objects;

/**
 * Factory for retrieving {@link LedBorg} implementations.
 */
public class LedBorgFactory {

    private LedBorgFactory() {
        //empty method
    }

    /**
     * The available types of {@link LedBorg} implementations.
     */
    public enum TYPE {
        /**
         * A dummy implementation that logs the received actions.
         */
        DUMMY,
        /**
         * Connects to the physical device.
         */
        REAL
    }

    /**
     * Retrieve a {@link LedBorg} instance bases on the given{@link TYPE}.
     *
     * @param type The type of instance to retrieve.
     * @return A {@link LedBorg} instance.
     */
    public static LedBorg get(final TYPE type) {
        Objects.requireNonNull(type);
        if (TYPE.DUMMY.equals(type)) {
            return new LedBorgDummy();
        } else if (TYPE.REAL.equals(type)) {
            return new LedBorgImpl();
        }
        throw new IllegalArgumentException("Received unknown type " + type);
    }


}
