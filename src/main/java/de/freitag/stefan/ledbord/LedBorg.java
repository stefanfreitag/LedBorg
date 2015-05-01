package de.freitag.stefan.ledbord;


import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.SoftPwm;

import java.awt.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Interfaces with LedBorg hardware.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
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

    private boolean isBlinking;

    private Timer blinkTimer;

    /**
     * Initialize the LedBorg with the default pin layout given in {@link #LAYOUT}.
     */
    public LedBorg() {
        this.layout = LAYOUT;
        this.isBlinking = false;
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

    /**
     * Setup the communication with the LedBorg.
     */
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

    /**
     * Turn off the LedBorg by setting the displayed color to
     * {@code Color.Black}
     */
    public void off() {
        SoftPwm.softPwmWrite(layout.getRed().getAddress(), 0);
        SoftPwm.softPwmWrite(layout.getGreen().getAddress(), 0);
        SoftPwm.softPwmWrite(layout.getBlue().getAddress(), 0);
    }

    /**
     * Return the displayed {@link Color}.
     *
     * @return The displayed {@link Color}.
     */
    public Color getDisplayedColor() {
        return this.color;
    }

    /**
     * Return if the LedBorg is blinking or not.
     *
     * @return {@code true} if the LedBorg is blinking, {@code false} otherwise.
     */
    public boolean isBlinking() {
        return this.isBlinking;
    }

    public void blink(final boolean enable) {
        this.isBlinking = enable;
        if (enable) {
            blinkTimer = new Timer("Blink Timer");
            blinkTimer.schedule(new BlinkTask(), 0, 200);
        } else {
            if (blinkTimer != null) {
                blinkTimer.cancel();
                blinkTimer = null;
            }
        }
    }

    private class BlinkTask extends TimerTask {

        private boolean toggle = false;

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            if (toggle) {
                LedBorg.this.displayColor(LedBorg.this.getDisplayedColor());
            } else {
                LedBorg.this.off();
            }
            toggle = !toggle;
        }
    }
}
