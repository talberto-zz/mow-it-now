package com.github.talberto.mowitnow;

import java.util.Iterator;

public interface MowerConfigurationParser {

  /**
   * Returns an iterator to iterate over the actions
   * 
   * @return
   */
  public abstract Iterator<Action> actionIterator();

  /**
   * Parses and retrieves a {@link Mower}
   * 
   * @param grass
   * @return
   * @throws IllegalStateException
   */
  public abstract Mower parseMower(Grass grass) throws IllegalStateException;

}