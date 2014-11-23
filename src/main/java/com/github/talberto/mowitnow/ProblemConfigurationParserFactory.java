package com.github.talberto.mowitnow;

import java.io.Reader;

/**
 * A Factory that creates {@link DefaultProblemConfigurationParser}'s
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public interface ProblemConfigurationParserFactory {

  /**
   * Creates a new {@link DefaultProblemConfigurationParser}
   * 
   * @param reader the reader that the parser will use (and consume)
   * @return a new {@link DefaultProblemConfigurationParser}
   */
  public ProblemConfigurationParser newProblemConfigurationParser(Reader reader);
}
