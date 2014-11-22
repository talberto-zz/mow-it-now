package com.github.talberto.mowitnow;

import java.io.Reader;

/**
 * Default implementation for the {@link ProblemConfigurationParserFactory}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParserFactory implements ProblemConfigurationParserFactory {

  @Override
  public ProblemConfigurationParser newProblemConfigurationParser(Reader reader) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
