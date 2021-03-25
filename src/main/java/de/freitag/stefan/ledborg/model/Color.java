package de.freitag.stefan.ledborg.model;

import lombok.Value;

/** A color defined by float values [0;1] for red, green and blue. */
@Value
public class Color {

  float red;
  float green;
  float blue;

  public Color() {
    this(0.0f, 0.0f, 0.0f);
  }

  public Color(final float red, final float green, final float blue) {

    if (!Colors.isInRange.test(red)) {
      throw new IllegalArgumentException(
          "Invalid value " + red + " for red. Allowed range is [0;1].");
    }

    if (!Colors.isInRange.test(green)) {
      throw new IllegalArgumentException(
          "Invalid value " + green + " for green. Allowed range is [0;1].");
    }
    if (!Colors.isInRange.test(blue)) {
      throw new IllegalArgumentException(
          "Invalid value " + blue + " for blue. Allowed range is [0;1].");
    }

    this.red = red;
    this.green = green;
    this.blue = blue;
  }
}
