package com.github.talberto.mowitnow.parser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import com.github.talberto.mowitnow.parser.MowerConfigurationParser;

class DefaultMowerConfigurationParserIterator implements Iterator<MowerConfigurationParser> {
  protected final BufferedReader reader;
  protected String mowerConfLine;
  protected String actionsLine;
  
  protected DefaultMowerConfigurationParserIterator(Reader reader) {
    if(reader instanceof BufferedReader) {
      this.reader = (BufferedReader) reader;
    } else {
      this.reader = new BufferedReader(reader);
    }
  }

  @Override
  public boolean hasNext() {
    try {
      mowerConfLine = reader.readLine();
      if(mowerConfLine == null) {
        return false;
      }
      actionsLine = reader.readLine();
      if(actionsLine == null) {
        throw new IllegalStateException("The underlying source configuration is exhausted, couldn't extract the action list");
      }
      return true;
    } catch (IOException e) {
      throw new IllegalStateException("Underlying configuration source threw an unexpected exception", e);
    }
  }

  @Override
  public MowerConfigurationParser next() {
    if(mowerConfLine == null || actionsLine == null) {
      throw new IllegalStateException("Incoherent iterator state");
    }
    return new DefaultMowerConfigurationParser(mowerConfLine, actionsLine);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("This operation isn't supported");
  }
}