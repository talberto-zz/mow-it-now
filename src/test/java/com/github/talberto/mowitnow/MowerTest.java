package com.github.talberto.mowitnow;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class MowerTest {

  Point initialPosition = new Point(1, 2);
  Direction initialDirection = Direction.N;
  Point topRight = new Point(2,2);
  Grass grass = new Grass(topRight);
  Mower mower = new Mower(initialPosition, initialDirection, grass);
  
  @Test public void testMove() {
    
  }
}

