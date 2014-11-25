package com.github.talberto.mowitnow.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import com.github.talberto.mowitnow.Grass;
import com.github.talberto.mowitnow.geometry.Point;
/**
 * Tests for {@link DefaultProblemConfigurationParser}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultProblemConfigurationParserTest {
  
  @Test public void testParseGrass() {
    String grassConfiguration = "5 7";
    Reader inputReader = new StringReader(grassConfiguration);
    DefaultProblemConfigurationParser parser = new DefaultProblemConfigurationParser(inputReader);
    
    Grass grass = parser.parseGrass();
    Point topRight = grass.getTopRight();
    
    assertThat("X coordinate of top right point isn't correct", topRight.getX(), equalTo(5));
    assertThat("Y coordinate of top right point isn't correct", topRight.getY(), equalTo(7));
  }
  
  @Test(expected=IllegalStateException.class) public void parseGrassThrowsExceptionWhenInputExhausted() {
    String grassConfiguration = "";
    Reader inputReader = new StringReader(grassConfiguration);
    new DefaultProblemConfigurationParser(inputReader);
  }
}
