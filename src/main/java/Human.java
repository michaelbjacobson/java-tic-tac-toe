import java.util.Scanner;

public class Human implements Player {

    private String symbol;
    private Scanner scanner;

    Human(String symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    @Override
    public boolean isComputer() {
        return false;
    }

    @Override
    public int chooseMove(Game game) {
        return (this.scanner.nextInt() - 1);
    }

}
