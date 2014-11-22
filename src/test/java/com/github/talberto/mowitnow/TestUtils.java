package com.github.talberto.mowitnow;

import java.io.IOException;
import java.io.Reader;

/**
 * Some utils for testing purposes...
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class TestUtils {
  public static boolean contentEquals(Reader r1, Reader r2) throws IOException {
    int data1, data2;

    do {
      data1 = r1.read();
      data2 = r2.read();
      
      // Contents are different... return false
      if(data1 != data2) {
        return false;
      }
      // We reached the end of BOTH files and we didn't return... contents are equals
      if(data1 == -1 && data2 == -1) {
        return true;
      }
    } while(true);
  }
}