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
  
  protected final BufferedReader reader;
  protected final String grassConfLine;
  
  protected DefaultProblemConfigurationParser(Reader reader) {
    this.reader = new BufferedReader(reader);
    try {
      this.grassConfLine = this.reader.readLine();
    } catch (IOException e) {
      throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
    }
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.ProblemConfigurationParser#parseGrass()
   */
  @Override
  public Grass parseGrass() throws IllegalStateException {
    try {
      Scanner scanner = new Scanner(grassConfLine);
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      scanner.close();
      
      return new Grass(x, y);
    } catch (Exception e) {
      throw new IllegalStateException("The underlying configuration source threw an exception", e);
    }
  }

  @Override
  public Iterator<MowerConfigurationParser> mowerConfigurationParserIterator() {
    return new DefaultMowerConfigurationParserIterator(reader);
  }
}
