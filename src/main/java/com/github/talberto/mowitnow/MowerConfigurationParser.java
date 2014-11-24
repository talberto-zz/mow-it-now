package com.github.talberto.mowitnow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A parser for a Mower configuration.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class MowerConfigurationParser {

  protected static class MowerConfigurationParserIterator implements Iterator<MowerConfigurationParser> {
    protected BufferedReader reader;
    protected ProblemConfigurationParserFactory factory;
    
    protected MowerConfigurationParserIterator(ProblemConfigurationParserFactory factory, Reader reader) {
      this.factory = factory;
      this.reader = new BufferedReader(reader);
    }

    @Override
    public boolean hasNext() {
      try {
        reader.mark(1);
        int c = reader.read();
        reader.reset();
        
        if(c == -1) {
          return false;
        } else {
          return true;
        }
      } catch (IOException e) {
        throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
      }
    }

    @Override
    public MowerConfigurationParser next() {
      return factory.newMowerConfigurationParser(reader);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("This operation isn't supported");
    }
  }

  protected static class ActionIterator implements Iterator<Action> {
    protected DefaultProblemConfigurationParserFactory factory;
    protected BufferedReader reader;
    
    protected ActionIterator(DefaultProblemConfigurationParserFactory factory, Reader reader) {
      this.factory = factory;
      BufferedReader tmpLineReader = new BufferedReader(reader);
      String line;
      try {
        line = tmpLineReader.readLine();
        
        if(line == null) {
          line = "";
        }
      } catch (IOException e) {
        throw new IllegalStateException("The underlying configuration source threw an unexpected exception", e);
      }
      this.reader = new BufferedReader(new StringReader(line));
    }

    @Override
    public boolean hasNext() {
      try {
        reader.mark(1);
        int c = reader.read();
        reader.reset();
        
        if(c == -1) {
          return false;
        } else {
          return true;
        }
      } catch (IOException e) {
        throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
      }
    }

    @Override
    public Action next() {
      int c;
      try {
        c = reader.read();
      } catch (IOException e) {
        throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
      }
      
      if(c == -1) {
        throw new IllegalStateException("The underlying source configuration is exhausted");
      }
      
      char actionChar = (char) c;
      String actionString = Character.toString(actionChar);
      Action action = null;
      try {
        action = Action.valueOf(actionString);
      } catch (Exception e) {
        throw new IllegalStateException(String.format("Read invalid action: [%s]", action), e);
      }
      return action;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("This operation isn't supported");
    }
  }
  
  protected ProblemConfigurationParserFactory factory;
  protected BufferedReader reader;
  
  protected MowerConfigurationParser(ProblemConfigurationParserFactory factory, Reader reader) {
    this.factory = factory;
    this.reader = new BufferedReader(reader);
  }
  
  /**
   * Returns an iterator to iterate over the actions
   * 
   * @return
   */
  public Iterator<Action> actionIterator() {
    return factory.newActionIterator(reader);
  }

  /**
   * Parses and retrieves a {@link Mower}
   * 
   * @param grass
   * @return
   * @throws IllegalStateException
   */
  public Mower parseMower(Grass grass) throws IllegalStateException {
    try {
      String line = reader.readLine();
      Reader stringReader = new StringReader(line);
      Scanner scanner = new Scanner(stringReader);
      
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      String directionStr = scanner.next();
      scanner.close();
      
      Direction direction = Direction.valueOf(directionStr);
      
      return factory.newMower(x, y, direction, grass);
    } catch (IOException e) {
      throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
    }
  }
}
