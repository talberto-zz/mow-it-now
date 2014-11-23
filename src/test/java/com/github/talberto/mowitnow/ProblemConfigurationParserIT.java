package com.github.talberto.mowitnow;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
/**
 * Tests for {@link DefaultProblemConfigurationParser}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class ProblemConfigurationParserIT {

  ProblemConfigurationParserFactory parserFactory;
  
  @Before public void setup() {
    Injector injector = Guice.createInjector(MowItNowModule.newInstance());
    parserFactory = injector.getInstance(ProblemConfigurationParserFactory.class);
  }
  
  @Test public void testParseGrass() {
    String grassConfiguration = "5 7";
    Reader inputReader = new StringReader(grassConfiguration);
    ProblemConfigurationParser parser = parserFactory.newProblemConfigurationParser(inputReader);
    
    Grass grass = parser.parseGrass();
    Point topRight = grass.getTopRight();
    
    assertThat("X coordinate of top right point isn't correct", topRight.getX(), equalTo(5));
    assertThat("Y coordinate of top right point isn't correct", topRight.getY(), equalTo(7));
  }
  
  @Test(expected=IllegalStateException.class) public void parseGrassThrowsExceptionWhenInputExhausted() {
    String grassConfiguration = "";
    Reader inputReader = new StringReader(grassConfiguration);
    ProblemConfigurationParser parser = parserFactory.newProblemConfigurationParser(inputReader);
    
    Grass grass = parser.parseGrass();
    Point topRight = grass.getTopRight();
    
    assertThat("X coordinate of top right point isn't correct", topRight.getX(), equalTo(5));
    assertThat("Y coordinate of top right point isn't correct", topRight.getY(), equalTo(7));
  }
  
  @Test public void testHasMoreMowers() {
    String mowerConfiguration = "1 2 N";
    Reader inputReader = new StringReader(mowerConfiguration);
    ProblemConfigurationParser parser = parserFactory.newProblemConfigurationParser(inputReader);
    
    assertTrue(parser.hasMoreMowers());
  }
  
  @Test public void testHasMoreMowersWhenInputExhausted() {
    String mowerConfiguration = "";
    Reader inputReader = new StringReader(mowerConfiguration);
    ProblemConfigurationParser parser = parserFactory.newProblemConfigurationParser(inputReader);
    
    assertFalse(parser.hasMoreMowers());
  }
}
