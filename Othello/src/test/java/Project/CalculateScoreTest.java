package Project;

import OthelloGraphic.GamePainter;
import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculateScoreTest {

    static CalculateScore calculateScore;
    static GamePanel gamePanel;
    static GameData gameData;
    static GamePainter gamePainter;
    static Board gameBoard;

    @BeforeAll
    static void beforeAll() {
        gameData = GameData.getInstance();
        gamePainter = new GamePainter(gameData);
        gamePanel = new GamePanel(gamePainter, gameData);
        gameBoard = new Board(gamePanel);
        calculateScore = new CalculateScore(gameBoard);

    }

    @Test
    void testCalculateScore() {
        gameBoard.pieces.add(new Piece(3,2 , Color.BLACK));
        gameBoard.pieces.add(new Piece(4,2 , Color.BLACK));

        String answer = calculateScore.calculateScore();
        String expected = "Winner: Player 1";

        assertEquals(expected, answer);
    }


}