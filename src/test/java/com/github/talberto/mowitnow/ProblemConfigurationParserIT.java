package com.github.talberto.mowitnow;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;

import com.google.inject.Guice;
import com.google.inject.Injector;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Tests for {@link DefaultProblemConfigurationParser}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class ProblemConfigurationParserIT {

  ProblemConfigurationParser parser;
  ProblemConfigurationParserFactory parserFactory;
  
  @Before public void setup() {
    Injector injector = Guice.createInjector(MowItNowModule.newInstance());
    parserFactory = injector.getInstance(ProblemConfigurationParserFactory.class);
    String topRightCoordinates = "5 7";
    Reader inputReader = new StringReader(topRightCoordinates);
    parser = parserFactory.newProblemConfigurationParser(inputReader);
  }
  
  @Test public void testParseGrass() {
    Grass grass = parser.parseGrass();
    Point topRight = grass.getTopRight();
    
    assertThat("X coordinate of top right point isn't correct", topRight.getX(), equalTo(5));
    assertThat("Y coordinate of top right point isn't correct", topRight.getY(), equalTo(7));
  }
}
