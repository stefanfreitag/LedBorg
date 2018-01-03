package de.freitag.stefan.ledborg.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LedBorg dummy implementation.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
final class LedBorgDummy extends AbstractLedBorg {

    /**
     * The {@link Logger} for this class.
     */
    private final static Logger LOG = LogManager.getLogger(LedBorgDummy.class.getCanonicalName());

    /**
     * Initialize the {@link LedBorgDummy}.
     */
    public LedBorgDummy() {
        super();
    }


    @Override
    public void setup() {
        LOG.info("LedBorg setup");
        this.off();
    }
}
