package de.freitag.stefan.ledborg.model;


import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.SoftPwm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.Objects;

/**
 * Interfaces with LedBorg hardware.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
final class LedBorgImpl extends AbstractLedBorg {


    /**
     * The {@link Logger} for this class.
     */
    @SuppressWarnings("unused")
    private static final Logger LOG = LogManager.getLogger(LedBorgImpl.class.getCanonicalName());

    /**
     * Default layout. Taken from https://www.piborg.org/ledborg/specs.
     */
    private static final PinLayout DEFAULT_LAYOUT = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    /**
     * The actual layout.
     */
    private final PinLayout layout;
    /**
     * Initialize the LedBorg with the default pin layout given in {@link #DEFAULT_LAYOUT}.
     */
     LedBorgImpl() {
        this(DEFAULT_LAYOUT);
    }

    /**
     * Initialize the LedBorg with a pin layout.
     *
     * @param layout a {@code PinLayout}. Must not be {@code null}.
     */
    LedBorgImpl(final PinLayout layout) {
        super();
        Objects.requireNonNull(layout, "Pin layout not allowed to be null.");
        this.layout = layout;
    }

    @Override
    public void setup() {
        this.setupGpio(this.layout);
        this.setupPwm(this.layout);
        this.off();
    }

    /**
     * Setup the Raspberry Pi pin configuration.
     *
     * @param pinLayout The pin layout to use.
     */
    private void setupGpio(final PinLayout pinLayout) {
        assert pinLayout != null;
        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput ledRed = gpio.provisionDigitalOutputPin(pinLayout.getRed());
        ledRed.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        final GpioPinDigitalOutput ledGreen = gpio.provisionDigitalOutputPin(pinLayout.getGreen());
        ledGreen.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        final GpioPinDigitalOutput ledBlue = gpio.provisionDigitalOutputPin(pinLayout.getBlue());
        ledBlue.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
    }

    private void setupPwm(final PinLayout pinLayout) {
        assert pinLayout != null;
        SoftPwm.softPwmCreate(pinLayout.getRed().getAddress(), 0, 50);
        SoftPwm.softPwmCreate(pinLayout.getGreen().getAddress(), 0, 50);
        SoftPwm.softPwmCreate(pinLayout.getBlue().getAddress(), 0, 50);
    }

    @Override
    public void displayColor(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null");
        }
        final float[] colors = color.getRGBColorComponents(null);
        SoftPwm.softPwmWrite(layout.getRed().getAddress(), (int) (colors[0] * 50f));
        SoftPwm.softPwmWrite(layout.getGreen().getAddress(), (int) (colors[1] * 50f));
        SoftPwm.softPwmWrite(layout.getBlue().getAddress(), (int) (colors[2] * 50f));
        super.displayColor(color);
    }

    @Override
    public void off() {
        SoftPwm.softPwmWrite(layout.getRed().getAddress(), 0);
        SoftPwm.softPwmWrite(layout.getGreen().getAddress(), 0);
        SoftPwm.softPwmWrite(layout.getBlue().getAddress(), 0);
        super.off();
    }

    @Override
    public void on() {
        this.displayColor(this.getDisplayedColor());
        super.on();
    }

}
