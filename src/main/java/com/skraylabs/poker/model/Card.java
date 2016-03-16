package com.skraylabs.poker.model;

/**
 * A playing card.
 */
class Card implements Comparable<Card> {
  /**
   * Playing card rank (A, K, Q, J, 10-2).
   */
  Rank rank;

  /**
   * Playing card suit (Spades, Hearts, Diamond, Clubs).
   */
  Suit suit;

  /**
   * Constructor.
   *
   * @param rank playing card rank
   * @param suit playing card suit
   */
  Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  /**
   * Copy constructor.
   *
   * @param card non-null Card from which to copy member values.
   */
  Card(Card card) {
    this(card.rank, card.suit);
  }

  /**
   * Test equality with another object. Other object must be a Card with identical {link Rank} and
   * {@link Suit} values.
   *
   * @return true if {@code o} is a Card with the same rank and suit; false otherwise.
   */
  @Override
  public boolean equals(Object object) {
    boolean result = false;
    if (object instanceof Card) {
      Card card = (Card) object;
      if (card.rank == this.rank && card.suit == this.suit) {
        result = true;
      }
    }
    return result;
  }

  @Override
  public int compareTo(Card other) {
    if (other == null) {
      throw new NullPointerException("Argument must be non-null.");
    }
    // Check rank
    int result = 0;
    int myRank = this.rank.aceHighValue();
    int otherRank = other.rank.aceHighValue(); 
    if (myRank > otherRank) {
      result = 1;
    } else if (myRank < otherRank) {
      result = -1;
    } else if (myRank == otherRank) {
      // Check suit
      int mySuit = evaluateSuit(this.suit);
      int otherSuit = evaluateSuit(other.suit);
      if (mySuit == otherSuit) {
        result = 0;
      } else if (mySuit > otherSuit) {
        result = 1;
      } else if (mySuit < otherSuit) {
        result = -1;
      }
    }
    return result;
  }

  /**
   * Helper method to place Suits in descending order: spades, hearts, diamonds, clubs.
   *
   * @param suit to evaluate
   * @return 4 for spades, 3 for hearts, 2 diamonds, 1 for clubs
   */
  protected static int evaluateSuit(Suit suit) {
    int result = -1;
    switch (suit) {
      case Spades:
        result = 4;
        break;
      case Hearts:
        result = 3;
        break;
      case Diamonds:
        result = 2;
        break;
      case Clubs:
        result = 1;
        break;
      default:
        // This shouldn't happen
        throw new RuntimeException("Logic error.");
    }
    return result;
  }

  /**
   * Accessor: Playing card rank (A, K, Q, J, 10-2).
   * @return the rank
   */
  public Rank getRank() {
    return rank;
  }

  /**
   * Accessor: Playing card suit (Spades, Hearts, Diamond, Clubs).
   * @return the suit
   */
  public Suit getSuit() {
    return suit;
  }
}
