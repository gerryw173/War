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

		//Assign rank
		if(card.charAt(0) == '1')
			rank = "8";
		else if(ranks.contains(card.charAt(0)+""))
			rank = ranks.indexOf(card.charAt(0)+"") + "";
		else
			rank = "Unknown";

		//Assign suit
		if(card.contains("d"))
			suit = "Diamond";
		else if(card.contains("h"))
			suit = "Hearts";
		else if(card.contains("s"))
			suit = "Spades";
		else if(card.contains("c"))
			suit = "Clubs";
		else
			suit = "Unknown";
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
	 * @param other
	 * @return
	 */
	public int compareTo(Card other)
	{
		int result1 = Integer.parseInt(this.rank);		 //required to convert the String into int as
		int result2 = Integer.parseInt(other.getRank()); //my rank is stored in numerical values and when the rank
		return result1 - result2;						 //is over 10 compareTo method does not function as intended.
	}
	
	/**
	 * Returns the long notation of this Card object.
	 *         "Unknown" if the rank or suit is not known.
	 */
	public String toString()
	{
		String[] ranksName = new String[] {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Jack", "Queen", "King", "Ace"};		//word bank for longhand notation
		String rankrtn = "";
		rankrtn = ranksName[Integer.parseInt(this.rank)];   //conversion to Longhand notation


		if(rank.contains("Unknown") || suit.contains("Unknown"))
			return "Unknown";
		else
			return rankrtn + " of "+ suit;
	}
}
