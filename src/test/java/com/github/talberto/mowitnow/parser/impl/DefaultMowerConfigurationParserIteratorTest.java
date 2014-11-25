package com.github.talberto.mowitnow.parser.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

import org.junit.Test;

import com.github.talberto.mowitnow.parser.MowerConfigurationParser;

public class DefaultMowerConfigurationParserIteratorTest {
  
  @Test public void testHasNext() throws IOException {
    Reader inputReader = when(mock(BufferedReader.class).readLine()).thenReturn("dummy line").getMock();
    
    Iterator<MowerConfigurationParser> it = new DefaultMowerConfigurationParserIterator(inputReader);
    
    assertTrue("Iterator must return true when there is more input available", it.hasNext());
  }
  
  @Test public void hasNextReturnsFalseWhenInputExhausted() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<MowerConfigurationParser> it = new DefaultMowerConfigurationParserIterator(inputReader);
    
    assertFalse("Iterator must false when input is exhausted", it.hasNext());
  }
  
  @Test public void testNext() {
    String mowerConf = "1";
    Reader inputReader = new StringReader(mowerConf);
    DefaultMowerConfigurationParserIterator it = new DefaultMowerConfigurationParserIterator(inputReader);
    
    it.actionsLine = "dummy line";
    it.mowerConfLine = "dummy line";
    
    assertNotNull("MowerConfigurationParser returned by iterator cannot be null", it.next());
  }
  
  @Test(expected=UnsupportedOperationException.class) public void testRemove() {
    String mowerConf = "";
    Reader inputReader = new StringReader(mowerConf);
    Iterator<MowerConfigurationParser> it = new DefaultMowerConfigurationParserIterator(inputReader);
    
    it.remove();
  }
}
