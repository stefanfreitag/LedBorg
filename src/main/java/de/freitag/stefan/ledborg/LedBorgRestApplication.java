package de.freitag.stefan.ledborg;

import de.freitag.stefan.ledborg.controller.LedBorgController;
import de.freitag.stefan.ledborg.controller.LedBorgRestConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.servlets.CrossOriginFilter;

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
  public void run(final LedBorgRestConfiguration configuration, final Environment environment) {
    if (configuration == null) {
      throw new IllegalArgumentException("Configuration is null.");
    }
    if (environment == null) {
      throw new IllegalArgumentException("Environment is null.");
    }
    final LedBorgController resource = new LedBorgController();
    final FilterRegistration.Dynamic cors =
        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

    // Configure CORS parameters
    cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
    cors.setInitParameter(
        CrossOriginFilter.ALLOWED_HEADERS_PARAM,
        "X-Requested-With,Content-Type,Accept,Origin,Authorization");
    cors.setInitParameter(
        CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
    cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

    // Add URL mapping
    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    environment.jersey().register(resource);
    environment.healthChecks().register("borg-rest", resource);
  }
}
