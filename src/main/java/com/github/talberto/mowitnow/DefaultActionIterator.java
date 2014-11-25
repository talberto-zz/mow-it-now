package com.github.talberto.mowitnow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

class DefaultActionIterator implements Iterator<Action> {
  protected final BufferedReader reader;
  
  protected DefaultActionIterator(String actionLine) {
    this.reader = new BufferedReader(new StringReader(actionLine));
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