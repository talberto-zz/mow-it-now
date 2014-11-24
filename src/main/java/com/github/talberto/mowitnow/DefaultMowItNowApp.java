package com.github.talberto.mowitnow;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Default implementation for {@link MowItNowApp}
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
@Singleton
public class DefaultMowItNowApp implements MowItNowApp {

  protected ProblemConfigurationParserFactory configurationFactory;
  
  @Inject protected DefaultMowItNowApp(ProblemConfigurationParserFactory configurationFactory) {
    this.configurationFactory = configurationFactory;
  }

  @Override
  public void start(Reader inputReader, Writer outputWriter) throws IOException {
    // Load the configuration from the inputReader
    ProblemConfigurationParser problemConfParser = configurationFactory.newProblemConfigurationParser(inputReader);
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
      
      outputWriter.write(String.format("%s %s %s", position.getX(), position.getY(), orientation));
    }
  }
}
