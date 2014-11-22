package com.github.talberto.mowitnow;

/**
 * A ProblemConfigurationParser is responsible of parsing the configuration of the 
 * problem.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public interface ProblemConfigurationParser {

  /**
   * Parses the configuration of the {@link Grass}
   * 
   * @return the parsed {@link Grass}
   */
  Grass parseGrass();

  /**
   * @return true if there are more mowers to parse, false otherwise
   */
  boolean hasMoreMowers();

  /**
   * Retrieves the next {@link MowerConfigurationParser} in the flow
   * 
   * @return
   */
  MowerConfigurationParser nextMowerConfigurationParser();

}
