package com.github.talberto.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.github.talberto.mowitnow.geometry.Point;
import com.google.common.collect.ImmutableList;

public class MowerPathTest {

  @Test public void testMower1Path() {
    Grass grass = new Grass(5, 5);
    Mower mower = new Mower(1, 2, Direction.N, grass);
    List<Action> actions = ImmutableList.of(
        Action.G, 
        Action.A, 
        Action.G, 
        Action.A, 
        Action.G, 
        Action.A, 
        Action.G, 
        Action.A, 
        Action.A
        );
    
    for(Action a : actions) {
      mower = mower.perform(a);
    }
    
    assertThat("The final mower's position isn't correct", mower.getPosition(), equalTo(new Point(1, 3)));
    assertThat("The final mower's direction isn't correct", mower.getDirection(), equalTo(Direction.N));
  }
  
  @Test public void testMower2Path() {
    Grass grass = new Grass(5, 5);
    Mower mower = new Mower(3, 3, Direction.E, grass);
    List<Action> actions = ImmutableList.of(
        Action.A, 
        Action.A, 
        Action.D, 
        Action.A, 
        Action.A, 
        Action.D, 
        Action.A, 
        Action.D, 
        Action.D,
        Action.A
        );
    
    for(Action a : actions) {
      mower = mower.perform(a);
    }
    
    assertThat("The final mower's position isn't correct", mower.getPosition(), equalTo(new Point(5, 1)));
    assertThat("The final mower's direction isn't correct", mower.getDirection(), equalTo(Direction.E));
  }
  
  @Test public void testMower2PathWithMower1Stopped() {
    Grass grass = new Grass(5, 5);
    @SuppressWarnings("unused")
    Mower stopedMower = new Mower(1, 3, Direction.N, grass);
    Mower mower = new Mower(3, 3, Direction.E, grass);
    List<Action> actions = ImmutableList.of(
        Action.A, 
        Action.A, 
        Action.D, 
        Action.A, 
        Action.A, 
        Action.D, 
        Action.A, 
        Action.D, 
        Action.D,
        Action.A
        );
    
    for(Action a : actions) {
      mower = mower.perform(a);
    }
    
    assertThat("The final mower's position isn't correct", mower.getPosition(), equalTo(new Point(5, 1)));
    assertThat("The final mower's direction isn't correct", mower.getDirection(), equalTo(Direction.E));
  }
}
