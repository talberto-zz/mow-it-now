package com.github.talberto.mowitnow.parser.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import com.github.talberto.mowitnow.Action;

public class DefaultActionIteratorTest {
  
  @Test public void testHasNext() {
    String actionsLine = "1";
    Iterator<Action> it = new DefaultActionIterator(actionsLine);
    
    assertTrue("Iterator must return true when there is more input available", it.hasNext());
  }
  
  @Test public void hasNextReturnsFalseWhenInputExhausted() {
    String actionsLine = "";
    Iterator<Action> it = new DefaultActionIterator(actionsLine);
    
    assertFalse("Iterator must false when input is exhausted", it.hasNext());
  }
  
  @Test public void testNext() {
    String actionsLine = "DGA";
    Iterator<Action> it = new DefaultActionIterator(actionsLine);
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
    String actionsLine = "";
    Iterator<Action> it = new DefaultActionIterator(actionsLine);
    
    it.remove();
  }
}
