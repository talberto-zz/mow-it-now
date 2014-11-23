package com.github.talberto.mowitnow;

import java.io.Reader;

/**
 * A ProblemConfigurationParser is responsible of parsing the configuration of the 
 * problem.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParser implements ProblemConfigurationParser {

  protected Reader reader;
  
  protected DefaultProblemConfigurationParser(Reader reader) {
    this.reader = reader;
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#parseGrass()
   */
  @Override
  public Grass parseGrass() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#hasMoreMowers()
   */
  @Override
  public boolean hasMoreMowers() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#nextMowerConfigurationParser()
   */
  @Override
  public MowerConfigurationParser nextMowerConfigurationParser() {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
