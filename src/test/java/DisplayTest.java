import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DisplayTest {

    private String[] tiles;
    private Board board;
    private Display display;

//    @Before
//    public void setUp() {
//        tiles = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
//        board = Mockito.mock(Board.class);
//        display = new Display(board);
//        when(board.tiles()).thenReturn(tiles);
//    }

//    @Test
//    public void canConstructARepresentationOfTheBoard() {
//        String expectedResult = "\n 0 | 1 | 2 \n---+---+---\n 3 | 4 | 5 \n---+---+---\n 6 | 7 | 8 \n";
//        StringBuilder actualResult = display.boardGrid();
//        assertEquals(expectedResult.trim(), actualResult.toString().trim());
//    }

}