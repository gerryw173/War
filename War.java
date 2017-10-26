import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class War 
{
	private ArrayList<Card> p1 = new ArrayList<Card>();
	private ArrayList<Card> p2 = new ArrayList<Card>();
	
	public War()
	{

		ArrayList<Card> deck = new ArrayList<Card>();	//make deck
		String[] rank = {"2", "3", "4", "5", "6" , "7", "8", "9" , "10", "J" , "Q", "K", "A"};
		String[] suit = {"D", "H", "S", "C"};		//word banks to make decks from
		for (String str: suit) {					//loops match suits to each rank
			for (String str1: rank) {
				Card card = new Card(str1+str);
				deck.add(card);
			}
		}
		Collections.shuffle(deck);					//shuffle the deck before distributing
		for (int i = 0; i < 52; i++){					//distribute
			if(i < 26)
				p1.add(deck.get(i));
			else
				p2.add(deck.get(i));
		}
	}
	
	public War(ArrayList<Card> p1, ArrayList<Card> p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Prints out ">> WAR <<" when battle occurs and winner is not decided
	 * if winner is decided, returns the winner
	 * @return winner of the battle - "Player 1" if player 1 wins, "Player 2" if player 2 wins
	 */
	public String battle()
	{
		Boolean tie;								//true if tied
		String winner = "";							//Stores Winner
		ArrayList<Card> P1 = new ArrayList<Card>();	 //P1 and P2 are the output to be printed
		ArrayList<Card> P2 = new ArrayList<Card>();
		P1.add(p1.get(0));							//Sets up the first battle
		P2.add(p2.get(0));
		int index = 1; 								//the index of the battle

		if(P1.get(P1.size()-1).compareTo(P2.get(P2.size()-1)) == 0)
			tie = true;
		else
			tie = false;

		System.out.println(P1.get(0).getShortHand() + " vs " + P2.get(0).getShortHand());
		while(tie) {
			System.out.println(">> WAR! <<");
			for (int i = 0; i < 4; i++) {  				//adds 4 to the battle, if less than 4 available, doesn't add more
				if (p1.size() > index)
					P1.add(p1.get(P1.size()));
				if(p2.size() > index)
					P2.add(p2.get(P2.size()));
				index++;
			}
			System.out.println(P1.get(P1.size()-1).getShortHand() + " vs " + P2.get(P2.size()-1).getShortHand());
			if(P1.get(P1.size()-1).compareTo(P2.get(P2.size()-1)) != 0)			//loops until there is a winner
				tie = false;                                            		//tie becomes false and move on to the last battle
		}

		if(P1.get(P1.size()-1).compareTo(P2.get(P2.size()-1)) > 0)         		//Result of the Last Battle
			winner = "Player 1";												//in which one side always wins.
		else if(P1.get(P1.size()-1).compareTo(P2.get(P2.size()-1)) < 0)
			winner = "Player 2";

		for (int i = 0; i < P2.size(); i++){   	//"draw" the card from deck (remove the cards used from the OG deck)
			p2.remove(0);
		}
		for (int i = 0; i < P1.size(); i++){
			p1.remove(0);
		}

		//clean up the battle
		P1.addAll(P2);							//combine the cards used in battle to P1
		Collections.shuffle(P1);                //for Random Order
		//P1 (deck of the cards used in battle) added to the winning side.
		if(winner.contains("1"))
			p1.addAll(P1);
		else if(winner.contains("2"))
			p2.addAll(P1);

		return 	winner;
	}

	/**
	 *
	 * @return true if one player have 0 cards, otherwise false
	 */
	public boolean gameOver(){
		if(p1.size() == 0 || p2.size() ==0){
			return true;
		}
		return false;
	}

	/**
	 * formats the output in shorthand notation
	 * @return status of the players' hand
	 */
	public String toString()
	{
		ArrayList<String> rtn1 = new ArrayList<String>();			//ArrayList made of shorthand
		ArrayList<String> rtn2 = new ArrayList<String>();
		for (int i = 0; i < p1.size(); i++) {						//transfers shorthand notation of cards
			rtn1.add(p1.get(i).getShortHand());
		}
		for (int i = 0; i < p2.size(); i++) {
			rtn2.add(p2.get(i).getShortHand());
		}
		return "Player 1 (" + p1.size() + "): " + rtn1 + "\n" +
				"Player 2 (" + p2.size() + "): " + rtn2;
	}
}
