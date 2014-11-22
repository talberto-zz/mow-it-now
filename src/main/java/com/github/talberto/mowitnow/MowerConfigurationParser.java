package com.github.talberto.mowitnow;

/**
 * A parser for a Mower configuration.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public interface MowerConfigurationParser {

  /**
   * Retrieves the next Mower
   * 
   * @param grass
   * @return
   * @throws IllegalStateException if there isn't any Mower left in the configuration
   */
  public Mower nextMower(Grass grass) throws IllegalStateException;

  public Iterable<Action> parseActions();
}
