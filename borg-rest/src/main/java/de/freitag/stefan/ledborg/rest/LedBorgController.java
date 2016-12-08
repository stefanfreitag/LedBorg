package de.freitag.stefan.ledborg.rest;

import com.codahale.metrics.health.HealthCheck;
import de.freitag.stefan.ledborg.model.Color;
import de.freitag.stefan.ledborg.model.LedBorg;
import de.freitag.stefan.ledborg.model.LedBorgFactory;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/ledborg")
public final class LedBorgController extends HealthCheck{


    /**
     * Return the {@link Logger} for this class.
     */
    private static final Logger LOG =  Logger.getLogger(LedBorgController.class.getCanonicalName());

    private final LedBorg borg;

    /**
     * Creates a new {@link LedBorgController}.
     */
    public LedBorgController() {
        this.borg = LedBorgFactory.get(LedBorgFactory.TYPE.REAL);
        this.borg.setup();
    }

    /**
     * Perform a check of the application component.
     *
     * @return if the component is healthy, a healthy {@link Result}; otherwise, an unhealthy {@link
     * Result} with a descriptive error message or exception
     * @throws Exception if there is an unhandled error during the health check; this will result in
     *                   a failed health check
     */
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

    @GET
    @Path("/getColor")
    @Produces({MediaType.APPLICATION_JSON})
    public Color getColor() {
        return this.borg.getDisplayedColor();
    }

    @PUT
    @Path("/setColor")
    @Consumes({MediaType.APPLICATION_JSON})
    public void setColor(final @QueryParam("red") @DefaultValue("0.0f") String red,
                         final @QueryParam("green") @DefaultValue("0.0f") String green,
                         final @QueryParam("blue") @DefaultValue("0.0f") String blue
    ) {
        Color.Builder builder = new Color.Builder();
       this.borg.displayColor(builder.withGreen(Float.valueOf(green)).withRed(Float.valueOf(red)).withBlue(Float.valueOf(blue)).create());
    }


    @PUT
    @Path("/power")
    @Consumes({MediaType.APPLICATION_JSON})
    public void power(final @QueryParam("value") @DefaultValue("on") String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if ("on".equalsIgnoreCase(value)) {
            this.borg.on();
            LOG.info("Powering LedBorg on");
        } else if ("off".equalsIgnoreCase(value)) {
            this.borg.off();
            LOG.info("Powering LedBorg off");
        } else {
            LOG.info("Unknown value " + value);
        }

    }
}
