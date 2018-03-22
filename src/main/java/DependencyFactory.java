import java.util.Scanner;

public class DependencyFactory {

    public static Tile newTile(String defaultContent) {
        return new Tile(defaultContent);
    }

    public static Board newBoard(Tile[] tiles) {
        return new Board(3, tiles);
    }

    public static Display newDisplay() {
        return new Display();
    }

    public static Scanner newScanner() {
        return new Scanner(System.in);
    }

    public static Game newGame(Board board) {
        return new Game(board);
    }
}
