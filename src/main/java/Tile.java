import java.util.regex.Pattern;

public class Tile {

    private String defaultContent;
    private String content;
    private Colour colour;
    private boolean winningTile;

    Tile(String defaultContent) {
        this.defaultContent = defaultContent;
        this.content = this.defaultContent;
        this.colour = new Colour();
        this.winningTile = false;
    }

    public void reset() {
        this.content = this.defaultContent;
        this.winningTile = false;
    }

    public void flagAsWinningTile() {
        this.winningTile = true;
    }

    public boolean isWinningTile() {
        return this.winningTile;
    }

    public void setContent(String playerSymbol) {
        this.content = playerSymbol;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isFree() {
        return ( Pattern.matches("[0-9]", this.content) );
    }

    public String getFormattedContent() {
        if (isFree()) {
            return Integer.toString(( Integer.parseInt(getContent()) + 1 ));
        } else {
            if (this.isWinningTile()) {
                return colour.red(getContent());
            } else {
                return colour.cyan(getContent());
            }
        }
    }

}
