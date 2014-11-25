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
   * Retrieves an iterator to iterate over all the {@link DefaultMowerConfigurationParser}
   * 
   * @return
   */
  public abstract Iterator<MowerConfigurationParser> mowerConfigurationParserIterator();
}