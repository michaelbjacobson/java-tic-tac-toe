import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Board {

    private int gridSize;
    private int width;
    private Tile[] tiles;
    private int[][] winningCombinations;

    Board(int width, Tile[] tileArray) {
        this.tiles = tileArray;
        this.width = width;
        this.gridSize = (width * width);
        this.winningCombinations = calculateWinningCombinations();
    }

    private IntPredicate indexIsInBounds = (tileIndex) -> (tileIndex >= 0) && (tileIndex <= this.gridSize);
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
        return (availableTileIndices().length == this.gridSize);
    }

//    int[][] winningHorizontals() {
//
//    }

//    int[][] winningVerticals() {
//
//    }

    int[][] winningDiagonals() {
        int[] firstDiagonal = IntStream.iterate(0, i -> (i + (this.width + 1)))
                .limit(this.gridSize / this.width)
                .toArray();
        int[] secondDiagonal = IntStream.iterate((this.width - 1), i -> (i + (this.width - 1)))
                .limit(this.gridSize / this.width)
                .toArray();
        return new int[][] {firstDiagonal, secondDiagonal};
    }

    int[] cornerIndices() {
        int[] cornerIndices = new int[4];
        cornerIndices[0] = 0;
        cornerIndices[1] = (this.width - 1);
        cornerIndices[2] = (cornerIndices[1] * this.width);
        cornerIndices[3] = (cornerIndices[1] + cornerIndices[2]);
        return cornerIndices;
    }

    private int[][] calculateWinningCombinations() {
        return new int[][] {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };
    }


}
