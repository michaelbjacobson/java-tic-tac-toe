import java.util.Scanner;

public class Program {

    private static Scanner scanner = DependencyFactory.newScanner();
    private static Board board = DependencyFactory.newBoard();
    private static Display display = DependencyFactory.newDisplay();
    private static Game game;

    public static void run() {
        chooseGameMode();
        runGame();
    }

    private static Game game() {
        if (game == null) game = new Game(board());
        return game;
    }

    private static Board board() {
        if (board == null) board = new Board();
        return board;
    }

    private static Display display() {
        if (display == null) display = new Display();
        return display;
    }

    private static Player[] getPlayersForGameMode(int gameMode) {
        Player[] playersArray;
        switch (gameMode) {
            case 1: playersArray = new Player[] {new Human("X", scanner), new Computer("O")};
                break;
            case 2: playersArray = new Player[] {new Computer("X"), new Human("O", scanner)};
                break;
            case 3: playersArray = new Player[] {new Computer("X"), new Computer("O")};
                break;
            default: playersArray = new Player[] {};
                break;
        }
        return playersArray;
    }

    private static void clearOutput() {
        System.out.print(display().ANSI_HOME);
        System.out.print(display().ANSI_CLEAR_SCREEN);
        System.out.flush();
    }

    private static void chooseGameMode() {
        clearOutput();
        System.out.println(display().gameSetupMessage());
        int gameMode = scanner.nextInt();
        game().setPlayers(getPlayersForGameMode(gameMode));
    }

    private static void runGame() {
        while (!game().isOver()) {
            clearOutput();
            System.out.println(display().boardGrid(game().board));
            System.out.println(display().promptMessage(game().currentPlayer()));
            game().board.updateTile(game().currentPlayer().chooseMove(game()), game().currentPlayer());
        }
        game().flagWinningTiles();
        clearOutput();
        System.out.println(display().boardGrid(game().board));
        System.out.println(display().gameOverMessage(game()));
    }

}
