package com.github.talberto.mowitnow;

import java.io.Reader;
import java.util.Iterator;

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

  /**
   * Creates a new {@link Grass} with the coordinates of the top right corner
   * 
   * @param x
   * @param y
   * @return a new and initialized {@link Grass} object
   */
  public Grass newGrass(int x, int y);

  /**
   * Creates a new {@link MowerConfigurationParser}
   * 
   * @param reader The Reader that will be used by the parser
   * @return
   */
  public MowerConfigurationParser newMowerConfigurationParser(Reader reader);

  /**
   * Creates an Iterator to iterate over the {@link MowerConfigurationParser}
   * 
   * @param reader
   * @return
   */
  public Iterator<MowerConfigurationParser> newMowerConfigurationParserIterator(Reader reader);

  /**
   * Creates a new {@link Mower} given the initial position and direction
   * 
   * @param x
   * @param y
   * @param direction
   * @return
   */
  public Mower newMower(int x, int y, Direction direction);

  /**
   * Creates and returns a new {@link Action} iterator
   * 
   * @param inputReader
   * @return
   */
  public Iterator<Action> newActionIterator(Reader reader);
}
