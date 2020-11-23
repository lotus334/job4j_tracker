package ru.job4j.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static List<Card> main() {
        return Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                        .map(value1 -> new Card(suit1, value1)))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit
                && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public static void main(String[] args) {
        List<Card> deck = Card.main();
        deck.add(new Card(Suit.Diamonds, Value.V_6));
        Map<Value, Suit> spades = new HashMap<>();
        Map<Value, Suit> hearts = new HashMap<>();
        Map<Value, Suit> diamonds = new HashMap<>();
        Map<Value, Suit> clubs = new HashMap<>();
        Stream.of(Value.values()).forEach(value1 -> {
            spades.put(value1, Suit.Spades);
            hearts.put(value1, Suit.Hearts);
            diamonds.put(value1, Suit.Diamonds);
            clubs.put(value1, Suit.Clubs);
        });
        boolean[] result = {true};
        for (Card card : deck) {
            if (
                    !(
                    spades.get(card.getValue()) != card.getSuit()
            || hearts.get(card.getValue()) != card.getSuit()
            || diamonds.get(card.getValue()) != card.getSuit()
            || clubs.get(card.getValue()) != card.getSuit()
            )
            ) {
                result[0] = false;
                break;
            }
        }
        if (deck.stream().distinct().count() < (long) deck.size()) {
            result[0] = false;
        }
        System.out.println(result[0]);
    }
}
