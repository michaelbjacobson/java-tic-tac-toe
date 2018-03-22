import java.util.Arrays;

public class Game {

    Board board;
    private Player[] players;
    private int[] winningCombo;

    Game(Board gameBoard) {
        this.winningCombo = null;
        this.board = gameBoard;
    }

    void setPlayers(Player[] players) {
        this.players = new Player[] {players[0], players[1]};
    }

    private Player getFirstPlayer() {
        return this.players[0];
    }

    private Player getSecondPlayer() {
        return this.players[1];
    }

    Player currentPlayer() {
        return ( board.availableTileIndices().length % 2 != 0 ) ? getFirstPlayer() : getSecondPlayer();
    }

    private boolean isWonBy(Player player) {
        for ( int[] combo: this.board.winningCombinations() ) {
            if (Arrays.stream(combo)
                    .allMatch(comboIndex -> this.board.tiles()[comboIndex].getContent().equals(player.symbol()) )) {
                this.winningCombo = combo;
                return true;
            }
        }
        return false;
    }

    void flagWinningTiles() {
        if (isWon()) {
            for (int tileIndex : this.winningCombo) {
                this.board.tiles()[tileIndex].flagAsWinningTile();
            }
        }
    }

    boolean isWon() {
        return ( isWonBy(getFirstPlayer()) || isWonBy(getSecondPlayer()) );
    }

    String winner() {
        if (isWon()) {
            return isWonBy(getFirstPlayer()) ? getFirstPlayer().symbol() : getSecondPlayer().symbol();
        }
        return null;
    }

    boolean isTied() {
        return ( this.board.availableTileIndices().length == 0 && !isWon() );
    }

    boolean isOver() {
        return ( isWon() || isTied() );
    }

}
