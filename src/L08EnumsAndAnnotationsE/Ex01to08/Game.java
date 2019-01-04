package L08EnumsAndAnnotationsE.Ex01to08;

public class Game {
    private enum Output {
        MESSAGE("%s wins with %s of %s.");

        private String message;

        Output(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    private enum Position {ONE, TWO}

    private Player[] players;

    public Game(Player... players) {
        this.players = players;
    }

    public Player getPlayers(int index) {
        return this.players[index];
    }

    public String getWinner() {
        Card playerOneCard = this.getPlayers(Position.ONE.ordinal()).getHighestPowerCard();
        Card playerTwoCard = this.getPlayers(Position.TWO.ordinal()).getHighestPowerCard();

        if (playerOneCard.compareTo(playerTwoCard) > 0) {
            return this.winnerString(this.getPlayers(Position.ONE.ordinal()), playerOneCard);
        } else {
            return this.winnerString(this.getPlayers(Position.TWO.ordinal()), playerTwoCard);
        }
    }

    private String winnerString(Player player, Card card) {
        return String.format(Output.MESSAGE.getMessage(), player, card.getRank(), card.getSuit());
    }
}
