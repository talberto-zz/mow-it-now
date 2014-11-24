package com.github.talberto.mowitnow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ActionIteratorIT {
ProblemConfigurationParserFactory parserFactory;
  
  @Before public void setup() {
    Injector injector = Guice.createInjector(MowItNowModule.newInstance());
    parserFactory = injector.getInstance(ProblemConfigurationParserFactory.class);
  }
  
  @Test public void testHasNext() {
    String mowerConf = "1";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    
    assertTrue("Iterator must return true when there is more input available", it.hasNext());
  }
  
  @Test public void hasNextReturnsFalseWhenInputExhausted() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    
    assertFalse("Iterator must false when input is exhausted", it.hasNext());
  }
  
  @Test public void testNext() {
    String mowerConf = "1";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    
    assertNotNull("MowerConfigurationParser returned by iterator cannot be null", it.next());
  }
  
  @Test(expected=UnsupportedOperationException.class) public void testRemove() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    
    it.remove();
  }
}
