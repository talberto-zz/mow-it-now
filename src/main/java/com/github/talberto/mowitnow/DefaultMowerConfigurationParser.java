package com.github.talberto.mowitnow;

import java.util.Iterator;
import java.util.Scanner;

/**
 * A parser for a Mower configuration.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class DefaultMowerConfigurationParser implements MowerConfigurationParser {
  
  protected final String mowerConfLine;
  protected final String actionsLine;
  
  protected DefaultMowerConfigurationParser(String mowerConfLine, String actionsLine) {
    this.mowerConfLine = mowerConfLine;
    this.actionsLine = actionsLine;
  }
  
  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.MowerConfigurationParser#actionIterator()
   */
  @Override
  public Iterator<Action> actionIterator() {
    return new DefaultActionIterator(actionsLine);
  }

  /* (non-Javadoc)
   * @see com.github.talberto.mowitnow.MowerConfigurationParser#parseMower(com.github.talberto.mowitnow.Grass)
   */
  @Override
  public Mower parseMower(Grass grass) throws IllegalStateException {
    Scanner scanner = new Scanner(mowerConfLine);
    
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    String directionStr = scanner.next();
    scanner.close();
    
    Direction direction = Direction.valueOf(directionStr);
    
    return new Mower(x, y, direction, grass);
  }
}
