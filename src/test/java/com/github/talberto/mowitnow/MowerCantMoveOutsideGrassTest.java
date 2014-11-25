package com.github.talberto.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MowerCantMoveOutsideGrassTest {

  @Parameters(name="{index}: Position {0}, Direction {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
            { new Point(0, 0), Direction.E},
            { new Point(0, 0), Direction.S},
            { new Point(2, 2), Direction.N},
            { new Point(2, 2), Direction.W},
        }
        );
  }
  
  @Parameter public Point initialPosition;
  @Parameter(value = 1) public Direction initialDirection;
  final Grass grass = new Grass(2, 2);
  
  @Test public void testMoveForward() {
    Mower mower = new Mower(initialPosition, initialDirection, grass);
    mower = mower.perform(Action.A);
    
    assertThat("The mower moved but he didn't have to", mower.getPosition(), equalTo(initialPosition));
  }
}
