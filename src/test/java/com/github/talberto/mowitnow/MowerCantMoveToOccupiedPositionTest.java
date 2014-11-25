package com.github.talberto.mowitnow;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MowerCantMoveToOccupiedPositionTest {

  @Test public void testMove() {
    Grass grass = new Grass(5, 5);
    Mower mower1 = new Mower(1, 1, Direction.N, grass);
    @SuppressWarnings("unused")
    Mower mower2 = new Mower(1, 2, Direction.N, grass);
    
    Mower mowerFinal = mower1.perform(Action.A);
    
    assertThat("The final position should be the same as the initial", mowerFinal.getPosition(), equalTo(mower1.getPosition()));
  }
}
