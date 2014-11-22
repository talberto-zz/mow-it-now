package com.github.talberto.mowitnow;

import java.io.Reader;
import java.io.Writer;

/**
 * Default implementation for {@link MowItNowApp}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultMowItNowApp implements MowItNowApp {

  protected DefaultMowItNowApp() {}

  @Override
  public Reader start(Reader inputReader, Writer outputWriter) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
