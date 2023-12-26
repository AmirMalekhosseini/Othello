package Project;

import OthelloGraphic.GamePainter;
import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculateMoveTest {

    static CalculateMove calculateMove;
    static GamePanel gamePanel;
    static MovePiece movePiece;
    static GamePainter gamePainter;
    static GameData gameData;

    @BeforeAll
    static void beforeAll() {
        gameData = GameData.getInstance();
        gamePainter = new GamePainter(gameData);
        gamePanel = new GamePanel(gamePainter, gameData);
        movePiece = new MovePiece(gamePanel);
        calculateMove = new CalculateMove(gamePanel, movePiece);
        calculateMove.gameBoard = new Board(gamePanel);
    }

    @Test
    public void testIsMoveValid() {
        movePiece.setXNewPiece(10);
        movePiece.setYNewPiece(10);

        boolean answer= calculateMove.isMoveValid();
        boolean expected = false;

        assertEquals(expected, answer);

    }

    @Test
    void isBoardPartEmpty() {
        calculateMove.gameBoard.pieces.add(new Piece(3, 3, Color.BLACK));
        calculateMove.gameBoard.updateBoard();
        movePiece.setXNewPiece(3);
        movePiece.setYNewPiece(3);

        boolean answer = calculateMove.isBoardPartEmpty();
        boolean expected = false;

        assertEquals(expected, answer);
    }
}