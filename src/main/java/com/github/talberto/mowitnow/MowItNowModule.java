package com.github.talberto.mowitnow;

import com.google.inject.AbstractModule;
import com.google.inject.Module;

/**
 * Guice module for the MowItNow app.
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class MowItNowModule extends AbstractModule {

  public static Module create() {
    return new MowItNowModule();
  }

  @Override
  protected void configure() {
    bind(MowItNowApp.class).to(DefaultMowItNowApp.class);
    bind(ProblemConfigurationParserFactory.class).to(DefaultProblemConfigurationParserFactory.class);
  }
}
