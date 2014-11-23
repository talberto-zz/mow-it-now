package com.github.talberto.mowitnow;

/**
 * A class that represents the grass.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Grass {

  final Point topRight;
  
  protected Grass(int x, int y) {
    this.topRight = new Point(x, y);
  }

  /**
   * Returns the top right point of the Grass
   * 
   * @return
   */
  public Point getTopRight() {
    return topRight;
  }
}
