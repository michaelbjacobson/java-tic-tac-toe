import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {

    private static Scanner scanner;
    private static Display display;
    private static Tile[] tiles;
    private static Board board;
    private static Game game;
    private static String[] symbols;

    public static void run() {
        createFreshGameAndDependencies();
        chooseGameMode();
        runGame();
    }

    private static void createFreshGameAndDependencies() {
        scanner = DependencyFactory.newScanner();
        display = DependencyFactory.newDisplay();
        tiles = createTilesArray();
        board = DependencyFactory.newBoard(tiles);
        game = DependencyFactory.newGame(board);
        symbols = new String[] {"X", "O"};
    }

    private static Tile[] createTilesArray() {
        Tile[] tilesArray = new Tile[9];
        IntStream.range(0, 9)
                .forEach( index -> tilesArray[index] = DependencyFactory.newTile(Integer.toString(index)) );
        return tilesArray;
    }

    private static Player[] getPlayersForGameMode(int gameMode) {
        Player[] playersArray;
        switch (gameMode) {
            case 1: playersArray = new Player[] {new Human(symbols[0], scanner), new Human(symbols[1], scanner)};
                break;
            case 2: playersArray = new Player[] {new Human(symbols[0], scanner), new Computer(symbols[1])};
                break;
            case 3: playersArray = new Player[] {new Computer(symbols[0]), new Human(symbols[1], scanner)};
                break;
            case 4: playersArray = new Player[] {new Computer(symbols[0]), new Computer(symbols[1])};
                break;
            default: playersArray = new Player[] {};
                break;
        }
        return playersArray;
    }

    private static void clearOutput() {
        System.out.print(display.ANSI_HOME);
        System.out.print(display.ANSI_CLEAR_SCREEN);
        System.out.flush();
    }

    private static void chooseGameMode() {
        clearOutput();
        System.out.println(display.gameSetupMessage());
        int gameMode = scanner.nextInt();
        game.setPlayers(getPlayersForGameMode(gameMode));
    }

    private static void runGame() {
        while (!game.isOver()) {
            clearOutput();
            System.out.println(display.boardGrid(game.board));
            System.out.println(display.promptMessage(game.currentPlayer()));
            game.board.updateTile(game.currentPlayer().chooseMove(game), game.currentPlayer());
        }
        game.flagWinningTiles();
        clearOutput();
        System.out.println(display.boardGrid(game.board));
        System.out.println(display.gameOverMessage(game));
    }

}
