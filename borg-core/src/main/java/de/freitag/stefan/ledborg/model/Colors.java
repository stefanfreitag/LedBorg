package de.freitag.stefan.ledborg.model;

import java.util.function.Function;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Colors {

  public boolean isInRange(final float value) {
    return value >= 0.0f && value <= 1.0f;
  }

  public Function<Color, Color> darker =
      (Color c) -> {
        final java.awt.Color color = new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue());
        float[] floats = color.darker().getColorComponents(null);
        return new Color(floats[0], floats[1], floats[2]);
      };

  public Function<Color, Color> brighter =
      (Color c) -> {
        final java.awt.Color color = new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue());
        float[] floats = color.brighter().getColorComponents(null);
        return new Color(floats[0], floats[1], floats[2]);
      };
}
