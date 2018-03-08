public class Colour {

    private final String ANSI_RESET = "\u001B[0m";

    public String cyan(String string) {
        final String ANSI_CYAN = "\u001B[36m";
        return ANSI_CYAN + string + ANSI_RESET;
    }

    public String red(String string) {
        final String ANSI_RED = "\u001B[31m";
        return ANSI_RED + string + ANSI_RESET;
    }

}
