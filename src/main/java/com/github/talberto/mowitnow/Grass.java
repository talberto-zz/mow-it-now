package com.github.talberto.mowitnow;

import java.util.Set;

import com.github.talberto.mowitnow.geometry.Point;
import com.google.common.collect.Sets;

/**
 * A class that represents the grass.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class Grass {

  final Point topRight;
  final Set<Point> occupiedPoints = Sets.newHashSet();
  
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

  public void addMower(Mower mower) {
    occupiedPoints.add(mower.getPosition());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((topRight == null) ? 0 : topRight.hashCode());
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
    Grass other = (Grass) obj;
    if (topRight == null) {
      if (other.topRight != null)
        return false;
    } else if (!topRight.equals(other.topRight))
      return false;
    return true;
  }

  public Point move(Mower mower, Direction direction) {
    Point newPosition = mower.move(direction);
    if(!occupiedPoints.contains(newPosition) && contains(newPosition)) {
      occupiedPoints.remove(mower.getPosition());
      occupiedPoints.add(newPosition);
      return newPosition;
    } else {
      return mower.getPosition();
    }
  }
}
