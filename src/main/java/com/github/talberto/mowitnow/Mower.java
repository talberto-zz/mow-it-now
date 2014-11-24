package com.github.talberto.mowitnow;

/**
 * Represents a Mower. A mower has a position and an orientation. A mower accepts actions
 * in order to move, which potentially modify it's position and orientation.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Mower {

  protected final Point position;
  protected final Direction direction;
  protected final Grass grass;
  
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
  public Mower perform(Action action) {
    Direction newDirection;
    Point newPosition;
    
    switch(action) {
    // Move forward
    case A:
      newPosition = position.apply(direction.vector());
      return new Mower(newPosition, direction, grass);

    // Turn left
    case G:
      newDirection = direction.turnLeft();
      return new Mower(position, newDirection, grass);
      
    // Turn right
    case D:
      newDirection = direction.turnRight();
      return new Mower(position, newDirection, grass);
      
    default:
      throw new UnsupportedOperationException(String.format("Action not supported [%s]", action));
    }
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
