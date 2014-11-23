package com.github.talberto.mowitnow;

import java.io.Reader;
import java.util.Iterator;

/**
 * A parser for a Mower configuration.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class MowerConfigurationParser {

  protected static class MowerConfigurationParserIterator implements Iterator<MowerConfigurationParser> {
    protected Reader reader;
    
    protected MowerConfigurationParserIterator(Reader reader) {
      this.reader = reader;
    }

    @Override
    public boolean hasNext() {
      throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public MowerConfigurationParser next() {
      throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("This operation isn't supported");
    }
  }

  protected Reader reader;
  
  protected MowerConfigurationParser(Reader reader) {
    this.reader = reader;
  }
  
  /**
   * Returns an iterator to iterate over the actions
   * 
   * @return
   */
  public Iterator<Action> actionIterator() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /**
   * Parses and retrieves a {@link Mower}
   * 
   * @param grass
   * @return
   * @throws IllegalStateException
   */
  public Mower parseMower(Grass grass) throws IllegalStateException {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
