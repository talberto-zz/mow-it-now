package com.github.talberto.mowitnow;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  MowerTurnsLeftTest.class,
  MowerTurnsRightTest.class,
  MowerMovesForwardTest.class,
  MowerCantMoveOutsideGrassTest.class
})
public class MowerTestSuite {
}

