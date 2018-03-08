import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ComputerTest {

    private int[] availableIndices;
    private Board board;
    private Computer computer;

//    @Before
//    public void setUp() {
//        availableIndices = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        board = Mockito.mock(Board.class);
//        computer = new Computer();
//        when(board.availableTileIndices()).thenReturn(availableIndices);
//    }

//    @Test
//    public void canChooseRandomNumberFromAvailableIndices() {
//        int choice = computer.chooseMove(board);
//        assertTrue( choice >= 0 && choice <= 8 );
//    }

}