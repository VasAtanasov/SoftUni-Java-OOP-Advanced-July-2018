package L08EnumsAndAnnotationsE.Ex01to08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;


public class Main {
    private static BufferedReader reader;
    private static Deck deck;


    static {
        deck = new Deck();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //    Problem 08. Deck of Cards
    public static void main(String[] args) throws IOException {
        Player playerOne = new Player(reader.readLine());
        Player playerTwo = new Player(reader.readLine());
        Game game = new Game(playerOne, playerTwo);

        giveCards(playerOne);
        giveCards(playerTwo);
        System.out.println(game.getWinner());

    }

    private static void giveCards(Player player) {
        while (! player.isHandComplete()) {
            try {
                String[] tokens = reader.readLine().toUpperCase().split(" OF ");
                if (! matchRank(tokens[0]) && ! matchSuit(tokens[1])) {
                    System.out.println("No such card exists.");
                    continue;
                }

                Rank rank = Enum.valueOf(Rank.class, tokens[0]);
                Suit suit = Enum.valueOf(Suit.class, tokens[1]);
                Card card = new Card(suit, rank);
                if (deck.contains(card)) {
                    player.takeCard(card);
                    deck.draw(card);
                } else {
                    System.out.println("Card is not in the deck.");
                }

            } catch (Exception ex) {
                System.out.println("No such card exists.");
            }
        }
    }

    private static boolean matchSuit(String token) {
        return Stream.of(Suit.values()).anyMatch(suit -> suit.name().equals(token));
    }

    private static boolean matchRank(String token) {
        return Stream.of(Rank.values()).anyMatch(rank -> rank.name().equals(token));
    }

//    This main method combines solutions for the following problems:
//    Problem 01. Card Suit
//    Problem 02. Card Rank
//    Problem 03. Cards with Power
//    Problem 04. Card toString()
//    Problem 06. Custom Enum Annotation
//    Problem 07. Deck of Cards
//
//    public static void main(String[] args) throws IOException {
//        String input = reader.readLine();
//
//        switch (input) {
//            case "Card Suits":
//                printSuit(input);
//                break;
//            case "Card Ranks":
//                printRank(input);
//                break;
//            case "Card Deck":
//                printDeck();
//                break;
//            case "Rank":
//                Class<Rank> rankClass = Rank.class;
//                printAnnotationParameters(rankClass);
//                break;
//            case "Suit":
//                Class<Suit> suitClass = Suit.class;
//                printAnnotationParameters(suitClass);
//                break;
//            default:
//                printCard(input);
//                break;
//        }
//
//    }
//
    /*=========================Problem 05. Card compareTo====================================================*/
//    public static void main(String[] args) throws IOException {
//        Rank rank = Enum.valueOf(Rank.class, reader.readLine());
//        Suit suit = Enum.valueOf(Suit.class, reader.readLine());
//        Card card = new Card(suit, rank);
//
//        Rank otherRank = Enum.valueOf(Rank.class, reader.readLine());
//        Suit otherSuit = Enum.valueOf(Suit.class, reader.readLine());
//        Card otherCard = new Card(otherSuit, otherRank);
//
//        if (card.compareTo(otherCard) > 0) {
//            System.out.println(card);
//        } else {
//            System.out.println(otherCard);
//        }
//    }

    private static void printAnnotationParameters(Class<?> classType) {
        if (classType.isAnnotationPresent(CardAnnotation.class)) {
            CardAnnotation annotation = classType.getAnnotation(CardAnnotation.class);
            System.out.println(String.format("Type = %s, Description = %s", annotation.type(), annotation.description()));
        }
    }

    private static void printDeck() {
        Stream.of(Suit.values())
                .forEach(suit -> Stream.of(Rank.values()).forEach(r -> System.out.println(String.format("%s of %s", r, suit))));
    }

    private static void printCard(String input) throws IOException {
        Rank rank = Enum.valueOf(Rank.class, input);
        Suit suit = Enum.valueOf(Suit.class, reader.readLine());
        Card card = new Card(suit, rank);
        System.out.println(card);
    }


    private static void printSuit(String input) {
        System.out.println(input + ":");
        EnumSet.allOf(Suit.class)
                .forEach(suit -> System.out.println(String.format("Ordinal value: %s; Name value: %s", suit.ordinal(), suit)));
    }

    private static void printRank(String input) {
        System.out.println(input + ":");
        EnumSet.allOf(Rank.class)
                .forEach(rank -> System.out.println(String.format("Ordinal value: %s; Name value: %s", rank.ordinal(), rank)));
    }

}
