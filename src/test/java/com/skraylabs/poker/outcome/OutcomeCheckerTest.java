package com.skraylabs.poker.outcome;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.skraylabs.poker.model.Card;
import com.skraylabs.poker.model.Rank;
import com.skraylabs.poker.model.Suit;
import com.skraylabs.poker.outcome.OutcomeChecker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class OutcomeCheckerTest {

  private Collection<Card> cards;
  private OutcomeChecker checker;

  @Before
  public void setUp() {
    cards = new ArrayList<>();
  }

  /* hasTwoOfAKind() test methods */

  @Test
  public void givenNegativeCardsHasTwoOfAKindReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.QUEEN, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasTwoOfAKind();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasTwoOfAKindReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasTwoOfAKind();

    assertThat(result, is(true));
  }

  /* hasThreeOfAKind() test methods */

  @Test
  public void givenNegativeCardsHasThreeOfAKindReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.QUEEN, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasThreeOfAKind();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasThreeOfAKindReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasThreeOfAKind();

    assertThat(result, is(true));
  }

  /* hasFourOfAKind() test methods */

  @Test
  public void givenNegativeCardsHasFourOfAKindReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.QUEEN, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFourOfAKind();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasFourOfAKindReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFourOfAKind();

    assertThat(result, is(true));
  }

  /* hasFlush() test methods */

  @Test
  public void givenNegativeCardsHasFlushReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.TWO, Suit.HEARTS));
    cards.add(new Card(Rank.THREE, Suit.HEARTS));
    cards.add(new Card(Rank.FOUR, Suit.HEARTS));
    cards.add(new Card(Rank.FIVE, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasFlushReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.TWO, Suit.HEARTS));
    cards.add(new Card(Rank.THREE, Suit.HEARTS));
    cards.add(new Card(Rank.FOUR, Suit.HEARTS));
    cards.add(new Card(Rank.FIVE, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFlush();

    assertThat(result, is(true));
  }

  /* hasTwoPair() test methods */

  @Test
  public void givenLessThanFourCardsHasTwoPairReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.KING, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasTwoPair();

    assertThat(result, is(false));
  }

  @Test
  public void givenNegativeCardsHasTwoPairReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.KING, Suit.HEARTS));
    cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
    cards.add(new Card(Rank.JACK, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasTwoPair();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasTwoPairReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.DIAMONDS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasTwoPair();

    assertThat(result, is(true));
  }

  /* hasFullHouse() test methods */

  @Test
  public void givenLessThanFiveCardsHasFullHouseReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFullHouse();

    assertThat(result, is(false));
  }

  @Test
  public void givenNegativeChardsHasFullHouseReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.SPADES));
    cards.add(new Card(Rank.TEN, Suit.SPADES));
    cards.add(new Card(Rank.JACK, Suit.SPADES));
    cards.add(new Card(Rank.KING, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFullHouse();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasFullHouseReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.ACE, Suit.SPADES));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.SPADES));
    cards.add(new Card(Rank.TEN, Suit.SPADES));
    cards.add(new Card(Rank.JACK, Suit.SPADES));
    cards.add(new Card(Rank.ACE, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasFullHouse();

    assertThat(result, is(true));
  }

  /* hasStraight() test methods */

  @Test
  public void givenLessThanFiveCardsHasStraightReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraight();

    assertThat(result, is(false));
  }

  @Test
  public void givenNegativeCardsHasStraightReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraight();

    assertThat(result, is(false));
  }

  @Test
  public void givenNegativeCardsWithDuplicateRanksHasStraightReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.SPADES));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraight();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasStraightReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.FIVE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraight();

    assertThat(result, is(true));
  }

  @Test
  public void givenPositiveCardsWithHighAceHasStraightReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
    cards.add(new Card(Rank.JACK, Suit.CLUBS));
    cards.add(new Card(Rank.TEN, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraight();

    assertThat(result, is(true));
  }

  /* hasStraightFlush() test methods */

  @Test
  public void givenLessThanFiveCardsHasStraightFlushReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraightFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenAFlushHasStraightFlushReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraightFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenAStraightHasStraightFlushReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.FIVE, Suit.HEARTS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraightFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasStraightFlushReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    cards.add(new Card(Rank.THREE, Suit.CLUBS));
    cards.add(new Card(Rank.FOUR, Suit.CLUBS));
    cards.add(new Card(Rank.FIVE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasStraightFlush();

    assertThat(result, is(true));
  }

  /* hasRoyalFlush() test methods */

  @Test
  public void givenNegativeCardsHasRoyalFlushReturnsFalse() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
    cards.add(new Card(Rank.JACK, Suit.CLUBS));
    cards.add(new Card(Rank.TWO, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasRoyalFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenAStraightFlushHasRoyalFlushReturnsFalse() {
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
    cards.add(new Card(Rank.JACK, Suit.CLUBS));
    cards.add(new Card(Rank.TEN, Suit.CLUBS));
    cards.add(new Card(Rank.NINE, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasRoyalFlush();

    assertThat(result, is(false));
  }

  @Test
  public void givenPositiveCardsHasRoyalFlushReturnsTrue() {
    cards.add(new Card(Rank.ACE, Suit.CLUBS));
    cards.add(new Card(Rank.KING, Suit.CLUBS));
    cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
    cards.add(new Card(Rank.JACK, Suit.CLUBS));
    cards.add(new Card(Rank.TEN, Suit.CLUBS));
    checker = new OutcomeChecker(cards);

    boolean result = checker.hasRoyalFlush();

    assertThat(result, is(true));
  }
}
