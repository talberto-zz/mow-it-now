package com.github.talberto.mowitnow;

import com.github.talberto.mowitnow.geometry.Point;

/**
 * A class that represents the grass.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Grass {

  final Point topRight;
  
  public Grass(int x, int y) {
    this(new Point(x, y));
  }

  public Grass(Point topRight) {
    this.topRight = topRight;
  }

  /**
   * Returns the top right point of the Grass
   * 
   * @return
   */
  public Point getTopRight() {
    return topRight;
  }

  public boolean contains(Point point) {
    return 0 <= point.getX() && point.getX() <= topRight.getX() && 0 <= point.getY() && point.getY() <= topRight.getY();
  }
}
