package com.github.talberto.mowitnow;

import java.util.Iterator;

public interface ProblemConfigurationParser {

  /**
   * Parses the configuration of the {@link Grass}
   * 
   * @throws IllegalStateException if there is no more configuration to read form the underlying configuration
   * source
   * 
   * @return the parsed {@link Grass}
   */
  public abstract Grass parseGrass() throws IllegalStateException;

  /**
   * @throws IllegalStateException if there is no more configuration to read form the underlying configuration
   * source
   * 
   * @return true if there are more mowers to parse, false otherwise
   */
  public abstract boolean hasMoreMowers() throws IllegalStateException;

  /**
   * Retrieves the next {@link MowerConfigurationParser} in the flow
   * 
   * @throws IllegalStateException if there is no more configuration to read form the underlying configuration
   * source
   * 
   * @return
   */
  public abstract MowerConfigurationParser nextMowerConfigurationParser() throws IllegalStateException;

  /**
   * Retrieves an iterator to iterate over all the {@link MowerConfigurationParser}
   * 
   * @return
   */
  public abstract Iterator<MowerConfigurationParser> mowerConfigurationParserIterator();
}