import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Board {

    private Tile[] tiles;
    private int[][] winningCombinations;

    Board() {
        this.winningCombinations = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        this.tiles = new Tile[] {
                new Tile("0"), new Tile("1"), new Tile("2"),
                new Tile("3"), new Tile("4"), new Tile("5"),
                new Tile("6"), new Tile("7"), new Tile("8"),
        };
    }

    private IntPredicate indexIsInBounds = (tileIndex) -> (tileIndex >= 0) && (tileIndex <= 8);
    private IntPredicate tileIsAvailable = (tileIndex) -> this.tiles[tileIndex].isFree();

    int[] availableTileIndices() {
        IntStream availableTileIndices = IntStream
                .range(0, this.tiles.length)
                .filter( index -> tileIsAvailable.test(index) );
        return availableTileIndices.toArray();
    }

    int[][] winningCombinations() {
        return this.winningCombinations;
    }

    Tile[] tiles() {
        return this.tiles;
    }

    void updateTile(int tileIndex, Player player) {
        if (indexIsInBounds.test(tileIndex) && tileIsAvailable.test(tileIndex)) {
            this.tiles[tileIndex].setContent(player.symbol());
        }
    }

    void resetTile(int tileIndex) {
        this.tiles[tileIndex].reset();
    }

    boolean isEmpty() {
        return (availableTileIndices().length == tiles().length);
    }

    int[] cornerIndices() {
        return new int[] {0, 2, 6, 8};
    }

}
