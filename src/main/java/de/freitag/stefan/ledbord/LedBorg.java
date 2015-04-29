package de.freitag.stefan.ledbord;


import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.SoftPwm;

import java.awt.*;
import java.util.Objects;

public final class LedBorg {

    /**
     * Default layout. Taken from https://www.piborg.org/ledborg/specs.
     */
    private static PinLayout LAYOUT = PinLayout.create(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
    /**
     * The actual layout.
     */
    private final PinLayout layout;

    /**
     * The currently shown/ set color.
     */
    private Color color;

    /**
     * Initialize the LedBorg with the default pin layout given in {@link #LAYOUT}.
     */
    public LedBorg() {
        this.layout = LAYOUT;
        this.color = Color.BLACK;
    }

    /**
     * Initialize the LedBorg with a pin layout.
     *
     * @param layout a {@code PinLayout}. Must not be {@code null}.
     */
    public LedBorg(final PinLayout layout) {
        super();
        Objects.requireNonNull(layout, "Pin layout not allowed to be null.");
        this.layout = layout;
    }


    public void setup() {
        this.setupGpio(this.layout);
        this.setupPwm(this.layout);
        this.off();
    }

    private void setupPwm(final PinLayout pinLayout) {
        assert pinLayout != null;
        SoftPwm.softPwmCreate(pinLayout.getRed().getAddress(), 0, 50);
        SoftPwm.softPwmCreate(pinLayout.getGreen().getAddress(), 0, 50);
        SoftPwm.softPwmCreate(pinLayout.getBlue().getAddress(), 0, 50);
    }

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

    public void displayColor(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null");
        }
        final float[] colors = color.getRGBColorComponents(null);
        SoftPwm.softPwmWrite(layout.getRed().getAddress(), (int) (colors[0] * 50f));
        SoftPwm.softPwmWrite(layout.getGreen().getAddress(), (int) (colors[1] * 50f));
        SoftPwm.softPwmWrite(layout.getBlue().getAddress(), (int) (colors[2] * 50f));
        this.color = color;
    }

    public void off() {
        this.displayColor(Color.BLACK);
    }

    public Color getDisplayedColor() {
        return this.color;
    }

}
