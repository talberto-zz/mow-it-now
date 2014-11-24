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
public class MowerTurnsLeftTest {

  final static Map<Direction, Direction> leftOf = ImmutableMap.<Direction, Direction>builder()
      .put(Direction.N, Direction.E)
      .put(Direction.E, Direction.S)
      .put(Direction.S, Direction.W)
      .put(Direction.W, Direction.N)
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
  
  @Test public void testMoveToRight() {
    Mower mower = new Mower(mock(Point.class), initialDirection, mock(Grass.class));
    mower = mower.perform(Action.D);
    
    assertThat("The mower didn't turn left correctly", mower.getDirection(), equalTo(leftOf.get(mower.getDirection())));
  }
}
