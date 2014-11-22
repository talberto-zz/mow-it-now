package com.github.talberto.mowitnow;

/**
 * A Point in the {@link Grass}, it has x and y coordinates
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Point {
  protected int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
