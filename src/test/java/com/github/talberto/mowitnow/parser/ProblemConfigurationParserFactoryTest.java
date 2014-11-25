package com.github.talberto.mowitnow.parser;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProblemConfigurationParserFactoryTest {

  @Test public void testNewFactory() {
    assertThat("The returned factory is null", ProblemConfigurationParserFactory.newFactory(), notNullValue());
  }
}
