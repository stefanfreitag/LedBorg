package de.freitag.stefan.ledborg.rest;

import de.freitag.stefan.ledborg.model.LedBorg;
import de.freitag.stefan.ledborg.model.LedBorgFactory;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;


@Path("/ledborg")
@Produces(MediaType.APPLICATION_JSON)
public final class LedBorgController {


    /**
     * Return the {@link Logger} for this class.
     */

    private static final Logger LOG =  Logger.getLogger(LedBorgController.class.getCanonicalName());

    private final LedBorg borg;

    /**
     * Creates a new {@link LedBorgController}.
     */
    public LedBorgController() {
        this.borg = LedBorgFactory.get(LedBorgFactory.TYPE.DUMMY);
        this.borg.setup();
    }



    @GET
    @Path("/getColor")
    @Produces({MediaType.APPLICATION_JSON})
    public Color getColor() {
        return this.borg.getDisplayedColor();
    }


    @PUT
    @Path("/setColor")
    public void setColor(final @QueryParam("value") @DefaultValue("Blue") String color) {
        this.borg.displayColor(Color.getColor(color));
    }

    @PUT
    @Path("/power")
    public void power(final @QueryParam("value") @DefaultValue("on") String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }

        if ("on".equalsIgnoreCase(value)) {
            this.borg.on();
        } else if ("off".equalsIgnoreCase(value)) {
            this.borg.off();
        }
    }
}
