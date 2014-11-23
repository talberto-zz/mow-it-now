package com.github.talberto.mowitnow;

public interface ProblemConfigurationParser {

  /**
   * Parses the configuration of the {@link Grass}
   * 
   * @return the parsed {@link Grass}
   */
  public abstract Grass parseGrass();

  /**
   * @return true if there are more mowers to parse, false otherwise
   */
  public abstract boolean hasMoreMowers();

  /**
   * Retrieves the next {@link MowerConfigurationParser} in the flow
   * 
   * @return
   */
  public abstract MowerConfigurationParser nextMowerConfigurationParser();
}