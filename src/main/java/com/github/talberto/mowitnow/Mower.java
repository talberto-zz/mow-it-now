package com.github.talberto.mowitnow;

import com.github.talberto.mowitnow.geometry.Point;

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
  
  public Mower(int x, int y, Direction direction, Grass grass) {
    this(new Point(x, y), direction, grass);
  }

  public Mower(Point position, Direction direction, Grass grass) {
    this.position = position;
    this.direction = direction;
    this.grass = grass;
    
    grass.addMower(this);
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
      newPosition = grass.move(this, direction);
      if(grass.contains(newPosition)) {
        return new Mower(newPosition, direction, grass);
      } else {
        return new Mower(position, direction, grass);
      }

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((direction == null) ? 0 : direction.hashCode());
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Mower other = (Mower) obj;
    if (direction != other.direction)
      return false;
    if (position == null) {
      if (other.position != null)
        return false;
    } else if (!position.equals(other.position))
      return false;
    return true;
  }

  public Point move(Direction moveTo) {
    return position.apply(moveTo.vector());
  }
}
