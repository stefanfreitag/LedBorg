package de.freitag.stefan.ledborg.model;

import java.util.function.Function;
import java.util.function.Predicate;
import lombok.experimental.UtilityClass;

/** Utility class for modifying colors. */
@UtilityClass
public class Colors {

  Predicate<Float> isInRange = value -> value >= 0.0f && value <= 1.0f;

  Function<Color, Color> darken =
      (Color c) -> {
        final java.awt.Color color = new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue());
        float[] floats = color.darker().getColorComponents(null);
        return new Color(floats[0], floats[1], floats[2]);
      };

  Function<Color, Color> brighten =
      (Color c) -> {
        final java.awt.Color color = new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue());
        float[] floats = color.brighter().getColorComponents(null);
        return new Color(floats[0], floats[1], floats[2]);
      };
}
