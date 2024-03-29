/*
This is the deck class.
The Card class which is in this file is also
needed for this to work correctly.
thank
*/
import java.util.*;
public class Deck {
	Random gen = new Random();
	List<Card> cards = new ArrayList<Card>();

	public Deck(Boolean... shuffle) {
		boolean shuf = shuffle.length > 0 ? shuffle[0] : true;
		
		this.reset(shuf);
		
	}

	void shuffle() {
		Collections.shuffle(this.cards);
	}

	Card getRandom(Boolean... remove) {

		boolean rem = remove.length > 0 ? remove[0] : true;

		int cardID = gen.nextInt(this.cards.size());
		Card card = this.cards.get(cardID);

		if (rem) this.cards.remove(cardID);

		return card;

	}

	List getCards() {
		return this.cards;
	}

	static int getIndex(String card) {

		String[] cardValues = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		for (int i=0;i<cardValues.length;i++) {
			if (cardValues[i].equals(card)) {
					return i;
			}
		}
		return -1;
	}


	void reset(Boolean... shuffle) {
		boolean shuf = shuffle.length > 0 ? shuffle[0] : true;

		String[] suites = new String[] {"hearts", "diamonds", "spades", "clubs"};

		String[] cardvalues = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		for (String suit: suites) {
			for (String card: cardvalues) {
				Card newCard = new Card(suit, card);
				this.cards.add(newCard);
			}
		}

		if (shuf) this.shuffle();
	}


}
