package com.github.talberto.mowitnow;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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
    // Parse each mower's configuration
    while(problemConfParser.hasMoreMowers()) {
      MowerConfigurationParser mowerConfParser = problemConfParser.nextMowerConfigurationParser();
      Mower mower = mowerConfParser.nextMower(grass);
      
      // Parse the actions
      for(Action action : mowerConfParser.parseActions()) {
        mower = mower.move(action);
      }
      
      Point position = mower.getPosition();
      Direction orientation = mower.getDirection();
      
      outputWriter.write(String.format("%s %s %s", position.getX(), position.getY(), orientation));
    }
  }
}
