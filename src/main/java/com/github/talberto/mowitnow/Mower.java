package com.github.talberto.mowitnow;

/**
 * Represents a Mower. A mower has a position and an orientation. A mower accepts actions
 * in order to move, which potentially modify it's position and orientation.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Mower {

  protected Point position;
  protected Direction direction;
  protected Grass grass;
  
  protected Mower(int x, int y, Direction direction, Grass grass) {
    this(new Point(x, y), direction, grass);
  }

  protected Mower(Point position, Direction direction, Grass grass) {
    this.position = position;
    this.direction = direction;
    this.grass = grass;
  }

  /**
   * Executes the action passed as parameter
   * 
   * @param action
   * @return
   */
  public Mower move(Action action) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /**
   * Get's the current position of the mower.
   * 
   * @return a {@link Point} reprensenting the mower's current position
   */
  public Point getPosition() {
    return position;
  }

  /**
   * Get's the {@link Direction} of the mower.
   * 
   * @return the {@link Direction} that the mower is pointing to
   */
  public Direction getDirection() {
    return direction;
  }
}
