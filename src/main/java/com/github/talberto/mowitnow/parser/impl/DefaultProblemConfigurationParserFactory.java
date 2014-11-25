package com.github.talberto.mowitnow.parser.impl;

import java.io.Reader;

import com.github.talberto.mowitnow.parser.ProblemConfigurationParser;
import com.github.talberto.mowitnow.parser.ProblemConfigurationParserFactory;

/**
 * Default implementation for the {@link ProblemConfigurationParserFactory}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParserFactory extends ProblemConfigurationParserFactory {

  @Override
  public ProblemConfigurationParser newProblemConfigurationParser(Reader reader) {
    return new DefaultProblemConfigurationParser(reader);
  }
}
