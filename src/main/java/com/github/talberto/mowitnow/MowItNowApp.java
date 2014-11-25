package com.github.talberto.mowitnow;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Iterator;

import com.github.talberto.mowitnow.geometry.Point;
import com.github.talberto.mowitnow.parser.MowerConfigurationParser;
import com.github.talberto.mowitnow.parser.ProblemConfigurationParser;
import com.github.talberto.mowitnow.parser.ProblemConfigurationParserFactory;

/**
 * Default implementation for {@link MowItNowApp}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class MowItNowApp {

  public static void main(String[] args) throws IOException {
    MowItNowApp app = new MowItNowApp();
    
    app.start(new InputStreamReader(System.in), new PrintWriter(System.out));
  }
  
  public void start(Reader inputReader, PrintWriter outputWriter) throws IOException {
    ProblemConfigurationParserFactory factory = ProblemConfigurationParserFactory.newFactory();
    // Load the configuration from the inputReader
    ProblemConfigurationParser problemConfParser = factory.newProblemConfigurationParser(inputReader);
    // Parse the grass configuration
    Grass grass = problemConfParser.parseGrass();
    // Iterate over all the mowers
    Iterator<MowerConfigurationParser> mowerIterator = problemConfParser.mowerConfigurationParserIterator();
    while(mowerIterator.hasNext()) {
      MowerConfigurationParser mowerConfParser = mowerIterator.next();
      Mower mower = mowerConfParser.parseMower(grass);
      
      // Parse the actions
      Iterator<Action> actionIterator = mowerConfParser.actionIterator();
      
      while(actionIterator.hasNext()) {
        Action action = actionIterator.next();
        mower = mower.perform(action);
      }
      
      Point position = mower.getPosition();
      Direction orientation = mower.getDirection();
      
      outputWriter.println(String.format("%s %s %s", position.getX(), position.getY(), orientation));
    }
  }
}
