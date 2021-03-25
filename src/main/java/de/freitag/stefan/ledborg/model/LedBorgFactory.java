package de.freitag.stefan.ledborg.model;

import java.util.Optional;
import lombok.NonNull;

/** Factory for retrieving {@link LedBorg} implementations. */
public class LedBorgFactory {

  private LedBorgFactory() {
    // empty method
  }

  /** The available types of {@link LedBorg} implementations. */
  public enum TYPE {
    /** A dummy implementation that logs the received actions. */
    DUMMY,
    /** Connects to the physical device. */
    REAL
  }

  /**
   * Retrieve a {@link LedBorg} instance bases on the given{@link TYPE}.
   *
   * @param type The type of instance to retrieve.
   * @return A {@link LedBorg} instance.
   */
  public static LedBorg get(@NonNull final TYPE type) {
    return Optional.of(type)
        .filter(t -> t.equals(TYPE.REAL))
        .map(t -> (LedBorg) new LedBorgImpl())
        .orElseGet(LedBorgDummy::new);
  }
}
