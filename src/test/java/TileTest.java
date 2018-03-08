import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    private Tile tile;
    private String examplePlayerSymbol = "X";

    @Before
    public void setUp() {
        String defaultTileContent = "0";
        tile = new Tile(defaultTileContent);
    }

    @Test
    public void canReturnItsContentWhenQueried() {
        String expectedTileContent = "0";
        String actualTileContent = tile.getContent();

        assertEquals(expectedTileContent, actualTileContent);
    }

    @Test
    public void canHaveItsContentUpdated() {
        tile.setContent(examplePlayerSymbol);

        String expectedTileContent = examplePlayerSymbol;
        String actualTileContent = tile.getContent();

        assertEquals(expectedTileContent, actualTileContent);
    }

    @Test
    public void canIndicateWhetherItsFreeWhenQueried() {
        boolean actualResultScenarioOne = tile.isFree();
        assertTrue(actualResultScenarioOne);

        tile.setContent(examplePlayerSymbol);
        boolean actualResultScenarioTwo = tile.isFree();
        assertFalse(actualResultScenarioTwo);
    }

    @Test
    public void isNotFlaggedAsAWinningTileByDefault() {
        assertFalse(tile.isWinningTile());
    }

    @Test
    public void canBeFlaggedAsAWinningTile() {
        tile.flagAsWinningTile();
        assertTrue(tile.isWinningTile());
    }

    @Test
    public void canBeResetToDefaultState() {
        tile.setContent(examplePlayerSymbol);
        tile.flagAsWinningTile();
        tile.reset();

        String expectedTileContent = "0";
        String actualTileContent = tile.getContent();

        assertFalse(tile.isWinningTile());
        assertEquals(expectedTileContent, actualTileContent);
    }

}