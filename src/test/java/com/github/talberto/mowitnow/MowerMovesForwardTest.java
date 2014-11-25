package com.github.talberto.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.github.talberto.mowitnow.geometry.Point;
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

  @Parameters(name="{index}: Direction {0}")
  public static Collection<Object[]> data() {
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
    Grass grass = mock(Grass.class);

    when(grass.contains(any(Point.class))).thenReturn(true);
    when(grass.move(any(Mower.class), any(Direction.class))).thenAnswer(new Answer<Point>() {
      @Override
      public Point answer(InvocationOnMock invocation) throws Throwable {
        Mower mower = invocation.getArgumentAt(0, Mower.class);
        Direction d = invocation.getArgumentAt(1, Direction.class);
        return mower.move(d);
      }
    });
    
    Mower mower = new Mower(initialPosition, initialDirection, grass);
    mower = mower.perform(Action.A);
    
    assertThat("The mower didn't move forward correctly", mower.getPosition(), equalTo(finalPosition.get(initialDirection)));
  }
}
