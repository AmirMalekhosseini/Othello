package Project;

import OthelloGraphic.GamePainter;
import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatePieceLocationTest {

    static GameData gameData;
    static GamePainter gamePainter;
    static GamePanel gamePanel;
    static CalculatePieceLocation calculatePieceLocation;
    static Piece piece;

    @BeforeAll
    static void beforeAll() {
        gameData = GameData.getInstance();
        gamePainter = new GamePainter(gameData);
        gamePanel = new GamePanel(gamePainter, gameData);
        calculatePieceLocation = new CalculatePieceLocation(gamePanel);
        piece = new Piece(4, 5, Color.BLACK);
    }

    @Test
    void testCalculateX() {
        int answer = calculatePieceLocation.calculateX(piece);
        int expected = 257;// Calculated using Sout

        assertEquals(expected, answer);
    }

    @Test
    void testCalculateY() {
        int answer = calculatePieceLocation.calculateY(piece);
        int expected = 289;// Calculated using Sout

        assertEquals(expected, answer);
    }
}