module.exports = class Deck {

  constructor(shuffle=true) {
    this.reset(shuffle);
  }

  get() {
    return this.cards;
  }
  
  static getIndex(a) {
    return [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', "A"].indexOf(a)

  }
  /**
   * cut the deck, get a random card.
   * @param {Bool} remove should be removed
   * @returns {Object} card returns a card object
   */
  getRandom(remove=true) {
    const numb = Math.round(Math.random()*(this.cards.length-1));

    const card = this.cards[numb]

    if (remove) this.cards.splice(numb, 1);

    return card;

  }

  /**
   * shuffle the deck, randomize it
   * @returns {Array} list of decks cards 
   */
  shuffle() {
    for (let i = this.cards.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
       
    } 
    return this.cards;
  }
  /**
   * Reset the deck to the original state.
   * @param {Bool} Shuffle on reset 
   * @returns {Deck} the deck object
   * 
   */
  reset(shuffle) {
    const suites = ["️♥️", "♦️", "♠️", "♣️"];
    const cards = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', "A"];
    this.cards = [];

    for (const suit of suites) {
      for (const card of cards) {
        this.cards.push({suit: suit, card: card});
      }
    }

    if(shuffle) this.shuffle();

  }
}
