package com.github.talberto.mowitnow.parser;

import java.io.Reader;
import java.util.ServiceLoader;

import com.github.talberto.mowitnow.parser.impl.DefaultProblemConfigurationParser;

/**
 * A Factory that creates {@link DefaultProblemConfigurationParser}'s
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public abstract class ProblemConfigurationParserFactory {

  private static ServiceLoader<ProblemConfigurationParserFactory> factoryLoader = ServiceLoader.load(ProblemConfigurationParserFactory.class, ProblemConfigurationParserFactory.class.getClassLoader());
  /**
   * Creates a new {@link ProblemConfigurationParserFactory}
   * 
   * @param reader the reader that the parser will use (and consume)
   * @return a new {@link ProblemConfigurationParserFactory}
   */
  public abstract ProblemConfigurationParser newProblemConfigurationParser(Reader reader);
  
  /**
   * Creates a new {@link ProblemConfigurationParserFactory}
   * 
   * @param reader the reader that the parser will use (and consume)
   * @return a new {@link ProblemConfigurationParserFactory}
   */
  public static ProblemConfigurationParserFactory newFactory() {
    for(ProblemConfigurationParserFactory factory : factoryLoader) {
      if(factory != null) {
        return factory;
      }
    }
    throw new IllegalStateException("ServiceLoader couldn't find any ProblemConfigurationParserFactory");
  }
}
