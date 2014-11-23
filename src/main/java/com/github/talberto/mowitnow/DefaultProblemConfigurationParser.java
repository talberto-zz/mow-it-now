package com.github.talberto.mowitnow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A ProblemConfigurationParser is responsible of parsing the configuration of the 
 * problem.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParser implements ProblemConfigurationParser {

  protected ProblemConfigurationParserFactory factory;
  protected BufferedReader reader;
  
  protected DefaultProblemConfigurationParser(ProblemConfigurationParserFactory factory, Reader reader) {
    this.factory = factory;
    this.reader = new BufferedReader(reader);
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#parseGrass()
   */
  @Override
  public Grass parseGrass() throws IllegalStateException {
    try {
      String line = reader.readLine();
      
      if(line == null) {
        throw new IllegalStateException("Unexpected end of the configuration source");
      }
      
      Scanner scanner = new Scanner(line);
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      scanner.close();
      
      return factory.newGrass(x, y);
    } catch (Exception e) {
      throw new IllegalStateException("The underlying configuration source threw an exception", e);
    }
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#hasMoreMowers()
   */
  @Override
  public boolean hasMoreMowers() throws IllegalStateException {
    try {
      // Assume that if there is at least one more char in the reader, there are more configurations
      reader.mark(1);
      int c = reader.read();
      
      if(c == -1) {
        return false;
      } else {
        reader.reset();
        return true;
      }
    } catch (IOException e) {
      throw new IllegalStateException("Error reading from underlying reader", e);
    }
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#nextMowerConfigurationParser()
   */
  @Override
  public MowerConfigurationParser nextMowerConfigurationParser() throws IllegalStateException {
    return factory.newMowerConfigurationParser(reader);
  }

  @Override
  public Iterator<MowerConfigurationParser> mowerConfigurationParserIterator() {
    return factory.newMowerConfigurationParserIterator(reader);
  }
}
