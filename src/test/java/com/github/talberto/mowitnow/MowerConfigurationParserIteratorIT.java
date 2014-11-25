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

public class MowerConfigurationParserIteratorIT {

  ProblemConfigurationParserFactory parserFactory;
  
  @Before public void setup() {
    Injector injector = Guice.createInjector(MowItNowModule.newInstance());
    parserFactory = injector.getInstance(ProblemConfigurationParserFactory.class);
  }
  
  @Test public void testHasNext() {
    String mowerConf = "1";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<DefaultMowerConfigurationParser> it = parserFactory.newMowerConfigurationParserIterator(inputReader);
    
    assertTrue("Iterator must return true when there is more input available", it.hasNext());
  }
  
  @Test public void hasNextReturnsFalseWhenInputExhausted() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<DefaultMowerConfigurationParser> it = parserFactory.newMowerConfigurationParserIterator(inputReader);
    
    assertFalse("Iterator must false when input is exhausted", it.hasNext());
  }
  
  @Test public void testNext() {
    String mowerConf = "1";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<DefaultMowerConfigurationParser> it = parserFactory.newMowerConfigurationParserIterator(inputReader);
    
    assertNotNull("MowerConfigurationParser returned by iterator cannot be null", it.next());
  }
  
  @Test(expected=UnsupportedOperationException.class) public void testRemove() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<DefaultMowerConfigurationParser> it = parserFactory.newMowerConfigurationParserIterator(inputReader);
    
    it.remove();
  }
}
