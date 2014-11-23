package com.github.talberto.mowitnow;

import java.io.Reader;
import java.util.Iterator;

/**
 * Default implementation for the {@link ProblemConfigurationParserFactory}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParserFactory implements ProblemConfigurationParserFactory {

  @Override
  public ProblemConfigurationParser newProblemConfigurationParser(Reader reader) {
    return new DefaultProblemConfigurationParser(this, reader);
  }

  @Override
  public Grass newGrass(int x, int y) {
    return new Grass(x, y);
  }

  @Override
  public MowerConfigurationParser newMowerConfigurationParser(Reader reader) {
    return new MowerConfigurationParser(reader);
  }

  @Override
  public Iterator<MowerConfigurationParser> newMowerConfigurationParserIterator(Reader reader) {
    return new MowerConfigurationParser.MowerConfigurationParserIterator(reader);
  }
}
