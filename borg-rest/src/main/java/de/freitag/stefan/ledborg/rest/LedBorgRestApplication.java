package de.freitag.stefan.ledborg.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LedBorg REST application.
 *
 * @author Stefan Freitag
 */
public final class LedBorgRestApplication extends Application<LedBorgRestConfiguration> {

    /**
     * Application entry point.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        try {
            new LedBorgRestApplication().run(args);
        } catch (Exception exception) {
            getLogger().error(exception.getMessage(), exception);
            System.exit(-1);
        }
    }

    /**
     * Return the {@link Logger} for this class.
     *
     * @return The {@link Logger} for this class.
     */
    private static Logger getLogger() {
        return LogManager.getLogger(LedBorgRestApplication.class.getCanonicalName());
    }

    @Override
    public String getName() {
        return "ledborg";
    }

    @Override
    public void run(final LedBorgRestConfiguration configuration,
                    final Environment environment) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration is null.");
        }
        if (environment == null) {
            throw new IllegalArgumentException("Environment is null.");
        }
        final LedBorgController resource = new LedBorgController();
        environment.jersey().register(resource);
    }
}