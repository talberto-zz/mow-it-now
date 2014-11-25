package com.github.talberto.mowitnow.parser;

import java.util.Iterator;

import com.github.talberto.mowitnow.Action;
import com.github.talberto.mowitnow.Grass;
import com.github.talberto.mowitnow.Mower;

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