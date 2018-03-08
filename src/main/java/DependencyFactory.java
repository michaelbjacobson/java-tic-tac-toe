import java.util.Scanner;

public class DependencyFactory {

    public static Board newBoard() {
        return new Board();
    }

    public static Display newDisplay() {
        return new Display();
    }

    public static Scanner newScanner() {
        return new Scanner(System.in);
    }
}
