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
		rank = numRank();
		suit = suitRank();
		shortHand = rank + suit;
	}

	private String suitRank()
	{
		suit = suit.toLowerCase();

		String[] faces = {"j", "q", "k", "a", "d", "h", "s", "c"};
		String[] faceRank = {"jack", "queen", "king", "ace", "diamonds", "hearts", "spades", "clubs"};

		if(suit != "j" && suit != "q" && suit != "k" && suit != "a" && suit != "d" && suit != "h" && suit != "s" && suit != "c")
		{
			return "Unknown";
		}

		for (int i = 0; i < faces.length ; i++)
		{
			if(suit.equals(faces[i]))
			{
				suit = faceRank[i];
			}
		}

		return suit;
	}

	private String numRank()
	{
		rank = rank.toLowerCase();

		String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
		if(rank != "2" && rank != "3" && rank != "4" && rank != "5" && rank != "6" && rank != "7" && rank != "8" &&
				rank != "9" && rank != "10")
		{
			return "Unknown";
		}

		return rank;
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
		Card one = new Card("");
		one = other;
	}
	
	/**
	 * Returns the long notation of this Card object.
	 *         "Unknown" if the rank or suit is not known.
	 */
	public String toString()
	{

	}
}
