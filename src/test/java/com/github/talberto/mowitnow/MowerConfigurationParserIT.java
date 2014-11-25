package com.github.talberto.mowitnow;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MowerConfigurationParserIT {

  ProblemConfigurationParserFactory parserFactory;
  
  @Before public void setup() {
    Injector injector = Guice.createInjector(MowItNowModule.newInstance());
    parserFactory = injector.getInstance(ProblemConfigurationParserFactory.class);
  }
  
  @Test public void testParseMower() {
    String mowerConf = "1 2 N";
    StringReader inputReader = new StringReader(mowerConf);
    Grass grass = new Grass(1, 1);
    MowerConfigurationParser mowerParser = new DefaultMowerConfigurationParser(parserFactory, inputReader);
    
    Mower mower = mowerParser.parseMower(grass);
    
    Point position = mower.getPosition();
    assertThat("The x of the mower's position isn't correct", position.getX(), equalTo(1));
    assertThat("The y of the mower's position isn't correct", position.getY(), equalTo(2));
    assertThat("The direction of the mower isn't correct", mower.getDirection(), equalTo(Direction.N));
  }
  
  @Test public void testActionIterator() {
    String mowerConf = "";
    StringReader inputReader = new StringReader(mowerConf);
    MowerConfigurationParser mowerParser = parserFactory.newMowerConfigurationParser(inputReader);
    
    assertNotNull("Returned action iterator cannot be null", mowerParser.actionIterator());
  }
}
