package com.github.talberto.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
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
    String mowerConf = "DGA";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    Action action = it.next();
    
    assertThat("Action returned by iterator cannot be null", action, notNullValue());
    assertThat("The first action isn't correct", action, equalTo(Action.D));
    
    action = it.next();
    
    assertThat("Action returned by iterator cannot be null", action, notNullValue());
    assertThat("The second action isn't correct", action, equalTo(Action.G));
    
    action = it.next();
    
    assertThat("Action returned by iterator cannot be null", action, notNullValue());
    assertThat("The third action isn't correct", action, equalTo(Action.A));
  }
  
  @Test(expected=UnsupportedOperationException.class) public void testRemove() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<Action> it = parserFactory.newActionIterator(inputReader);
    
    it.remove();
  }
}
