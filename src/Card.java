public class Card implements Comparable<Card>
{
	private String rank;
	private String suit;
	private String shortHand;

	/**
	 * Constructs a card from a short-hand notation.
	 *
	 * Assigns "Unknown" to rank or suit if the rank or suit
	 * cannot be determined from the shorthand notation, i.e.
	 * the notation contains invalid characters.
	 *
	 * Not case sensitive.
	 * @param card
	 */
	public Card(String card)
	{
		shortHand = card;
		card = card.toLowerCase();

		String ranks = "234567891jqka";

		if(card.charAt(0) == '1')
		{
			rank = "8";
		}
		else if(ranks.contains(card.charAt(0) + ""))
		{
			rank = ranks.indexOf(card.charAt(0) + "") + "";
		}
		else
		{
			rank = "Unknown";
		}


		if(card.contains("d"))
		{
			suit = "Diamond";
		}
		else if(card.contains("h"))
		{
			suit = "Hearts";
		}
		else if(card.contains("s"))
		{
			suit = "Spades";
		}
		else if(card.contains("c"))
		{
			suit = "Clubs";
		}
		else
		{
			suit = "Unknown";
		}
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public String getShortHand()
	{
		return shortHand;
	}
	
	/**
	 * Returns a negative number if the rank of this card is less than
	 *         the rank of the other card.
	 *         a positive number if the rank of this card is greater than
	 *         the rank of the other card.
	 *         0 if the ranks of this and other are equal.
	 *         
	 * @param other
	 * @return
	 */
	public int compareTo(Card other)
	{
		//converts strings into integers
		int rank1 = Integer.parseInt(this.rank);
		int rank2 = Integer.parseInt(other.getRank());
		return rank1 - rank2;
	}
	
	/**
	 * Returns the long notation of this Card object.
	 * "Unknown" if the rank or suit is not known.
	 */
	public String toString()
	{
		if(shortHand.contains("Unknown"))
		{
			return "Unknown";
		}
		String longRank = ""; // long notation of rank
		String longSuit = ""; // long notation of suit

		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k","a"};
		String[] longRanks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		String[] suits = {"d", "h", "s", "c"};
		String[] longSuits = {"Diamonds", "Hearts", "Spades", "Clubs"};

		for(int i = 0; i < ranks.length; i++)
		{
			if(rank == ranks[i])
			{
				longRank = longRanks[i];
				break;
			}
		}

		for(int i = 0; i < suits.length; i++)
		{
			if(suit == suits[i])
			{
				longSuit = longSuits[i];
				break;
			}
		}

		return longRank + " of " + longSuit;
	}
}
