package com.skraylabs.poker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.skraylabs.poker.model.BoardFormatException;
import com.skraylabs.poker.model.CardFormatException;
import com.skraylabs.poker.model.GameState;
import com.skraylabs.poker.model.GameStateFactory;
import com.skraylabs.poker.model.GameStateFormatException;
import com.skraylabs.poker.model.PocketFormatException;

import org.junit.Test;

public class FlushTest {

  @Test
  public void givenBustedHandReturnsZeroProbability() throws BoardFormatException,
      PocketFormatException, GameStateFormatException, CardFormatException {
    GameState game = GameStateFactory.createGameStateFromString("As Ac Ah Kh\n Ts Js");
    ProbabilityCalculator calculator = new ProbabilityCalculator(game);

    double probability = calculator.flushForPlayer(0);

    assertThat(probability, equalTo(0.0));
  }

  @Test
  public void givenFlushDrawAndTwoChancesReturnsCorrectProbability() throws BoardFormatException,
      PocketFormatException, GameStateFormatException, CardFormatException {
    GameState game = GameStateFactory.createGameStateFromString("As 2s Kh\n 4s 5s");
    ProbabilityCalculator calculator = new ProbabilityCalculator(game);

    double probability = calculator.flushForPlayer(0);

    assertThat(probability, equalTo(378.0 / 1081.0));
  }
}
