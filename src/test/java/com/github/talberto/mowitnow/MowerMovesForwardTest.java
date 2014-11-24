package com.github.talberto.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableMap;

@RunWith(Parameterized.class)
public class MowerMovesForwardTest {

  private static final Point initialPosition = new Point(0, 0);
  final static Map<Direction, Point> finalPosition = ImmutableMap.<Direction, Point>builder()
      .put(Direction.N, new Point(0, 1))
      .put(Direction.E, new Point(-1, 0))
      .put(Direction.S, new Point(0, -1))
      .put(Direction.W, new Point(1, 0))
      .build();

  @Parameters public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
            { Direction.N },
            { Direction.S },
            { Direction.W },
            { Direction.E }
        }
        );
  }

  @Parameter public Direction initialDirection;
  
  @Test public void testMoveForward() {
    Mower mower = new Mower(initialPosition, initialDirection, mock(Grass.class));
    mower = mower.perform(Action.A);
    
    assertThat("The mower didn't move forward correctly", mower.getPosition(), equalTo(finalPosition.get(mower.getDirection())));
  }
}
