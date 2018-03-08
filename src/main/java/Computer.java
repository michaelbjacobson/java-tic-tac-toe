import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Computer implements Player {

    private String symbol;

    Computer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    @Override
    public boolean isComputer() {
        return true;
    }

    @Override
    public int chooseMove(Game game) {
        int nextMove;
        if (game.board.isEmpty()) {
            nextMove = openingGambit(game.board);
        } else {
            Map<Integer, Integer> bestScore = new HashMap<>();
            nextMove = miniMax(game, 0, bestScore);
        }
        waitOneSecond();
        return nextMove;
    }

    private void waitOneSecond() {
        try { Thread.sleep(1000); }
        catch( InterruptedException ex ) { Thread.currentThread().interrupt(); }
    }

    private int openingGambit(Board board) {
        Random rand = new Random();
        int[] corners = board.cornerIndices();
        int index = rand.nextInt(corners.length);
        return corners[index];
    }

    private int heuristicValue(Game game) {
        if (game.isWon()) {
            return -1;
        } else {
            return 0;
        }
    }

    private int bestMove(Map<Integer, Integer> scoresMap) {
        return scoresMap.entrySet()
                .stream()
                .max( Map.Entry.comparingByValue() )
                .get()
                .getKey();
    }

    private int bestScore(Map<Integer, Integer> scoresMap) {
        return scoresMap.entrySet()
                .stream()
                .max( Map.Entry.comparingByValue() )
                .get()
                .getValue();
    }

    private int miniMax(Game game, int depth, Map<Integer, Integer> scoresMap) {
        if (game.isOver()) {
            return heuristicValue(game);
        } else {
            for ( int tileIndex : game.board.availableTileIndices() ) {
                game.board.updateTile(tileIndex, game.currentPlayer());
                scoresMap.put(tileIndex, ( -1 * miniMax(game, depth + 1, new HashMap<>()) ));
                game.board.resetTile(tileIndex);
            }
            if (depth == 0) {
                return bestMove(scoresMap);
            } else {
                return bestScore(scoresMap);
            }
        }
    }

}
