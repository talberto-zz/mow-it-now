package com.github.talberto.mowitnow;

import java.io.Reader;
import java.io.Writer;

/**
 * Main class of the exercise
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public interface MowItNowApp {

  
  /**
   * Starts the application. It will read the configuration from the reader passed as an argument
   * and write the output to the writer passed as the second arguments
   * 
   * @param inputReader Where to read the configuration from
   * @param outputWriter Where to write the output to
   */
  public Reader start(Reader inputReader, Writer outputWriter);
}
