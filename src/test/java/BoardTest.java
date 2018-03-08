import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BoardTest {

//    private Board board;
//    private Tile[] mockTilesArray;
//
//    @Before
//    public void setUp() {
//        board = new Board();
//        mockTilesArray = new Tile[] {
//                Mockito.mock(Tile.class), Mockito.mock(Tile.class), Mockito.mock(Tile.class),
//                Mockito.mock(Tile.class), Mockito.mock(Tile.class), Mockito.mock(Tile.class),
//                Mockito.mock(Tile.class), Mockito.mock(Tile.class), Mockito.mock(Tile.class)
//        };
//    }
//
//    @Test
//    public void boardIsInstantiatedWithArrayOfTiles() {
//
//        Tile[] expectedResult = mockTilesArray;
//        Tile[] actualResult = board.tiles();
//        assertArrayEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    public void canGetArrayOfAvailableTileIndices() {
//        int[] expectedResult = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] actualResult = board.availableTileIndices();
//        assertArrayEquals(expectedResult, actualResult);
//    }

//    @Test
//    public void canUpdateATilesContent() {
//        board.updateTile(0, "X");
//        String expectedResult = "X";
//        String actualResult = board.tiles()[0];
//        assertEquals(expectedResult, actualResult);
//    }

//    @Test
//    public void willNotUpdateOccupiedTile() {
//        board.updateTile(0, "X");
//        board.updateTile(0, "O");
//        String expectedResultAfter = "X";
//        String actualResultAfter = board.tiles()[0];
//        assertEquals(expectedResultAfter, actualResultAfter);
//    }

//    @Test
//    public void willNotBlowUpIfGivenOutOfBoundsIndex() {
//        int outOfBoundsIndex = 10;
//        board.updateTile(outOfBoundsIndex, "X");
//    }

}