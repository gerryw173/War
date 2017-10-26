import java.util.ArrayList;
import java.util.Collections;

public class War 
{
	private ArrayList<Card> p1;
	private ArrayList<Card> p2;
	
	public War()
	{
		ArrayList<Card> deck = new ArrayList<Card>();
		String[] ranks = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		for (int i = 0; i < 13; i++)
		{
			String card = "D";
			card = ranks[i] + card;
			Card currentCard = new Card(card);
			deck.add(currentCard);
		}
		for (int i = 0; i < 13; i++)
		{
			String card = "H";
			card = ranks[i] + card;
			Card currentCard = new Card(card);
			deck.add(currentCard);
		}
		for (int i = 0; i < 13; i++)
		{
			String card = "S";
			card = ranks[i] + card;
			Card currentCard = new Card(card);
			deck.add(currentCard);

		}
		for (int i = 0; i < 13; i++)
		{
			String card = "C";
			card = ranks[i] + card;
			Card currentCard = new Card(card);
			deck.add(currentCard);
		}

		p1 = new ArrayList<Card>();
		p2 = new ArrayList<Card>();
		Collections.shuffle(deck);

		while (deck.size() > 0)
		{
			p1.add((deck.remove(0)));
			p2.add((deck.remove(0)));
		}
	}

	public War(ArrayList<Card> p1, ArrayList<Card> p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Returns >> WAR! << if there is no winner
	 * @return
	 */
	public String battle()
	{

		ArrayList<Card> Player1 = new ArrayList<Card>();
		ArrayList<Card> Player2 = new ArrayList<Card>();

		Boolean ifTied; // not tied at start

		String winner = "";

		Player1.add(p1.get(0));
		Player2.add(p2.get(0));
		int battleIndex = 1; //index of where the battle is occuring


		if(Player1.get(Player1.size() - 1).compareTo(Player2.get(Player2.size() - 1)) == 0) //
		{
			ifTied = true;
		}
		else
		{
			ifTied = false;
		}

		System.out.println(Player1.get(0).getShortHand() + " vs " + Player2.get(0).getShortHand());

		while(ifTied)
		{
			System.out.println(">> WAR! <<");

			for (int i = 0; i < 4; i++) // does not add any more if there are less than 4
			{
				if (p1.size() > battleIndex)
				{
					Player1.add(p1.get(Player1.size()));
				}
				if(p2.size() > battleIndex)
				{
					Player2.add(p2.get(Player2.size()));
				}
				battleIndex++;
			}

			System.out.println(Player1.get(Player1.size() - 1).getShortHand() + " vs " + Player2.get(Player2.size() - 1).getShortHand());

			if(Player1.get(Player1.size() - 1).compareTo(Player2.get(Player2.size() - 1)) != 0) //loops until winner determined
			{
				ifTied = false;
			}
		}

		if(Player1.get(Player1.size() - 1).compareTo(Player2.get(Player2.size() - 1)) > 0)
		{
			winner = "Player 1";
		}
		else if(Player1.get(Player1.size() - 1).compareTo(Player2.get(Player2.size() - 1)) < 0)
		{
			winner = "Player 2";
		}

		for (int i = 0; i < Player2.size(); i++) // moves card to other deck
		{
			p2.remove(0);
		}
		for (int i = 0; i < Player1.size(); i++)
		{
			p1.remove(0);
		}

		Player1.addAll(Player2);

		Collections.shuffle(Player1);

		if(winner.contains("1"))
		{
			p1.addAll(Player1);
		}
		else if(winner.contains("2"))
		{
			p2.addAll(Player1);
		}

		return 	winner;
	}

	/**
	 * returns true if 0 cards left
	 * @return
	 */
	public boolean gameOver()
	{
			if(p1.size() == 0 || p2.size() == 0)
			{
				return true;
			}

			return false;
	}
	
	public String toString()
	{
		ArrayList<String> shortHand1 = new ArrayList<String>();
		ArrayList<String> shortHand2 = new ArrayList<String>();

		for (int i = 0; i < p1.size(); i++)
		{
			shortHand1.add(p1.get(i).getShortHand());
		}
		for (int i = 0; i < p2.size(); i++)
		{
			shortHand2.add(p2.get(i).getShortHand());
		}

		return "Player 1 (" + p1.size() + "): " + shortHand1 + "\n" +
				"Player 2 (" + p2.size() + "): " + shortHand2;
	}
}
