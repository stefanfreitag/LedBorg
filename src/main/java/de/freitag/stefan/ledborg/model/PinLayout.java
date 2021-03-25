package de.freitag.stefan.ledborg.model;

import com.pi4j.io.gpio.Pin;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * Pin layout used as part of the {@link LedBorgImpl}.
 *
 * @author Stefan Freitag (stefan@stefreitag.de)
 */
@Builder
@Value
class PinLayout {

  /** The {@link com.pi4j.io.gpio.Pin} the red LED is connected to. */
  @NonNull Pin red;
  /** The {@link com.pi4j.io.gpio.Pin} the green LED is connected to. */
  @NonNull Pin green;
  /** The {@link com.pi4j.io.gpio.Pin} the blue LED is connected to. */
  @NonNull Pin blue;
}
