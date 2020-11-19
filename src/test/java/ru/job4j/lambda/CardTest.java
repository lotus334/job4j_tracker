package ru.job4j.lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CardTest {
    /*
    Проверяет на правильное соответствие масть-значение
    и на правильное количество карт в коллоде.
     */
    @Test
    public void createValidDeckOfCards() {
        List<Card> deck = Card.main();
        boolean[] result = {true};
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

        if (deck.stream().distinct().count() < deck.stream().count()) {
            result[0] = false;
        }

        assertThat(result[0], is(true));
    }

    @Test
    public void createInvalidDeckOfCards() {
        List<Card> deck = Card.main();
        boolean[] result = {true};

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

        deck.add(new Card(Suit.Diamonds, Value.V_6));

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

        if (deck.stream().distinct().count() < deck.stream().count()) {
            result[0] = false;
        }

        assertThat(result[0], is(false));
    }
}