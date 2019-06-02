package de.freitag.stefan.ledborg.model;

import de.freitag.stefan.ledborg.model.utils.Colors;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Interfaces with LedBorg hardware.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
abstract class AbstractLedBorg implements LedBorg {

  /** The {@link Logger} for this class. */
  private static final Logger LOG = LogManager.getLogger(AbstractLedBorg.class.getCanonicalName());

  /** The currently shown/ set color. */
  private Color color;

  private boolean on;

  /** Stores the blinking status. */
  private boolean blinking;

  private Timer blinkTimer;
  /** The default blink rate. */
  private static final BlinkRate DEFAULT_RATE = BlinkRate.ONE_SECOND;

  /** The currently set blink rate. */
  private BlinkRate blinkRate = DEFAULT_RATE;

  /**
   * Create a new {@link AbstractLedBorg}.
   *
   * <ul>
   *   <li>Blinking is disabled.
   *   <li>Default color is black
   * </ul>
   */
  AbstractLedBorg() {
    this.blinking = false;
    this.color = new Color();
  }

  @Override
  public final Color getDisplayedColor() {
    return this.color;
  }

  @Override
  public void displayColor(final Color color) {
    if (color == null) {
      throw new IllegalArgumentException("Color is null");
    }
    this.color = color;
    LOG.info("Set displayed color to " + this.color);
  }

  @Override
  public final void brighter() {
    this.displayColor(Colors.brighter.apply(this.color));
  }

  @Override
  public final void darker() {
    this.displayColor(Colors.darker.apply(this.color));
  }

  @Override
  public void on() {
    LOG.info("Turning LedBorg on.");
    this.on = true;
  }

  @Override
  public void off() {
    LOG.info("Turning LedBorg off.");
    this.on = false;
  }

  @Override
  public boolean isOn() {
    return on;
  }

  @Override
  public final boolean isBlinking() {
    return this.blinking;
  }

  @Override
  public final void setBlinkRate(final BlinkRate blinkRate) {
    if (blinkRate == null) {
      throw new IllegalArgumentException("BlinkRate is null");
    }
    this.blinkRate = blinkRate;
    LOG.info("Set blinking rate to " + this.blinkRate);
  }

  @Override
  public final void blink(final boolean enable) {
    this.blinking = enable;
    if (enable) {
      blinkTimer = new Timer("Blink Timer");
      blinkTimer.schedule(new BlinkTask(), 0, this.blinkRate.getBlinkRate());
    } else {
      if (blinkTimer != null) {
        blinkTimer.cancel();
        blinkTimer = null;
      }
    }
  }

  private class BlinkTask extends TimerTask {

    private boolean toggle;

    /** The action to be performed by this timer task. */
    @Override
    public void run() {
      if (toggle) {
        displayColor(getDisplayedColor());
      } else {
        off();
      }
      toggle = !toggle;
    }
  }
}
