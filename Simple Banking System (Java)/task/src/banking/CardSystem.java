package banking;

public class CardSystem {
    //    private static final HashMap<String, Card> cardMap = new HashMap<>();
    private static CardSystem instance;

    public static synchronized CardSystem getInstance() {
        if (instance == null) {
            instance = new CardSystem();
        }
        return instance;
    }

   /* public void addCard(Card card) {
        if (cardMap.containsKey(card.getNumber())) {
            throw new IllegalArgumentException("Account number already exist");
        }
        cardMap.put(card.getNumber(), card);
        System.out.println(cardMap);
    }

    public Card getCardByNumber(String number) {
        return cardMap.get(number);
    }*/

    public Card addCard() {
        Card newCard = new Card();
        BankDB.createCardTableIfNotExist();
        int statusCode = BankDB.addNewCard(newCard);
        if (statusCode != 0) {
            return newCard;
        }
        return addCard();
    }

    public Card loginWithCredentials(String number, String PIN) {
        return BankDB.getRequestedNumber(number, PIN);
    }


}
