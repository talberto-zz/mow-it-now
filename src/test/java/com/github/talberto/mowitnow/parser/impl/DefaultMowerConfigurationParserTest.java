package com.github.talberto.mowitnow.parser.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.github.talberto.mowitnow.Direction;
import com.github.talberto.mowitnow.Grass;
import com.github.talberto.mowitnow.Mower;
import com.github.talberto.mowitnow.geometry.Point;
import com.github.talberto.mowitnow.parser.MowerConfigurationParser;

public class DefaultMowerConfigurationParserTest {
  
  @Test public void testParseMower() {
    String mowerConf = "1 2 N";
    String actionsLine = "";
    Grass grass = new Grass(1, 1);
    MowerConfigurationParser mowerParser = new DefaultMowerConfigurationParser(mowerConf, actionsLine);
    
    Mower mower = mowerParser.parseMower(grass);
    
    Point position = mower.getPosition();
    assertThat("The x of the mower's position isn't correct", position.getX(), equalTo(1));
    assertThat("The y of the mower's position isn't correct", position.getY(), equalTo(2));
    assertThat("The direction of the mower isn't correct", mower.getDirection(), equalTo(Direction.N));
  }
  
  @Test public void testActionIterator() {
    String mowerConf = "";
    String actionsLine = "";
    MowerConfigurationParser mowerParser = new DefaultMowerConfigurationParser(mowerConf, actionsLine);
    
    assertNotNull("Returned action iterator cannot be null", mowerParser.actionIterator());
  }
}
