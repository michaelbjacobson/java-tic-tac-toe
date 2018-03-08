class Display {

    public String ANSI_HOME = "\033[H";
    public String ANSI_CLEAR_SCREEN = "\033[2J";

    private StringBuilder gridRow(Board board, int startIndex) {
        String unicodeVerticalLine = " \u2502 ";
        return new StringBuilder()
                .append(" ")
                .append( (board.tiles()[startIndex]).getFormattedContent() )
                .append(unicodeVerticalLine)
                .append( board.tiles()[startIndex + 1].getFormattedContent() )
                .append(unicodeVerticalLine)
                .append( board.tiles()[startIndex + 2].getFormattedContent() )
                .append(" \n");
    }

    private StringBuilder rowDelimiter() {
        String unicodeHorizontalLine = "\u2500\u2500\u2500";
        String unicodeCross = "\u253c";
        return new StringBuilder()
                .append(unicodeHorizontalLine)
                .append(unicodeCross)
                .append(unicodeHorizontalLine)
                .append(unicodeCross)
                .append(unicodeHorizontalLine)
                .append("\n");
    }

    StringBuilder boardGrid(Board board) {
        StringBuilder rowDelimiter = rowDelimiter();
        return new StringBuilder()
                .append("\n")
                .append(gridRow(board, 0))
                .append(rowDelimiter)
                .append(gridRow(board, 3))
                .append(rowDelimiter)
                .append(gridRow(board, 6));
    }

    String gameOverMessage(Game game) {
        if (game.isTied()) {
            return "Tie game!\n";
        } else {
            return "Player " + game.winner() + " wins!\n";
        }
    }

    String promptMessage(Player currentPlayer) {
        if (currentPlayer.isComputer()) {
            return "Computer " + currentPlayer.symbol() + " is taking it's turn!\n";
        } else {
            return "Player " + currentPlayer.symbol() + " choose your move!\n";
        }
    }

    StringBuilder gameSetupMessage() {
        return new StringBuilder()
                .append("\nPlease select a game mode...\n\n")
                .append("1 - Human vs. Computer (Human goes first)\n")
                .append("2 - Computer vs. Human (Computer goes first)\n")
                .append("3 - Computer vs. Computer\n");
    }

}
