package com.github.talberto.mowitnow;

/**
 * A possible direction (N, W, S, E).
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public enum Direction {
  N(new Vector(0, 1)),
  W(new Vector(1, 0)),
  S(new Vector(0, -1)),
  E(new Vector(-1, 0));

  private static int NO_DIRECTIONS = values().length;
  private Vector vector;
  
  private Direction(Vector vector) {
    this.vector = vector;
  }
  /**
   * Turns at right
   * 
   * @return the result of turning at right the Direction represented by this
   */
  public Direction turnRight() {
    return Direction.values()[(this.ordinal() + 1) % NO_DIRECTIONS];
  }

  /**
   * Turns at left
   * 
   * @return the result of turning at left the Direction represented by this
   */
  public Direction turnLeft() {
    return Direction.values()[((this.ordinal() - 1) % NO_DIRECTIONS + NO_DIRECTIONS) % NO_DIRECTIONS];
  }

  public Vector vector() {
    return vector;
  }
}
