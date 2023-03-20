package banking;

import java.util.HashMap;


public class CardSystem {
    private static final HashMap<String, Card> cardMap = new HashMap<>();
    private static CardSystem instance;

    public static synchronized CardSystem getInstance() {
        if (instance == null) {
            instance = new CardSystem();
        }
        return instance;
    }

    public void addCard(Card card) {
        if (cardMap.containsKey(card.getNumber())) {
            throw new IllegalArgumentException("Account number already exist");
        }
        cardMap.put(card.getNumber(), card);
        System.out.println(cardMap);
    }

    public Card getCardByNumber(String number) {
        return cardMap.get(number);
    }

    public Card addCard() {
        Card newCard = new Card();
        if (cardMap.containsKey(newCard.getNumber())) {
            return addCard();
        }
        cardMap.put(newCard.getNumber(), newCard);
        return newCard;
    }
}
