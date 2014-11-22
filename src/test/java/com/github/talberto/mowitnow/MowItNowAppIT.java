package com.github.talberto.mowitnow;

import static com.github.talberto.mowitnow.StreamMatchers.contentEqualsTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author Tomás Rodríguez (rstomasalberto@gmail.com)
 *
 */
public class MowItNowAppIT {

  MowItNowApp app;

  @Before
  public void loadApp() {
    Injector injector = Guice.createInjector(MowItNowModule.create());
    app = injector.getInstance(MowItNowApp.class);
  }

  /**
   * Test that the app generates the expected output for the input given in the exercise
   * 
   * @throws IOException 
   */
  @Test
  public void testApp() throws IOException {
    try (Reader inputReader = new InputStreamReader(this.getClass().getResourceAsStream("input"), Charsets.UTF_8);
        Reader expectedOutputReader = new InputStreamReader(this.getClass().getResourceAsStream("output"), Charsets.UTF_8);
        PipedReader actualOutputReader = new PipedReader(1024);
        Writer outputWriter = new PipedWriter(actualOutputReader)) {
      app.start(inputReader, outputWriter);
      assertThat("The expected output and the actual output don't have the same contents", actualOutputReader, contentEqualsTo(expectedOutputReader));
    }
  }
}
