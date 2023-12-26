package Project;

import OthelloGraphic.GamePainter;
import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class ChangePlayerTurnTest {

    static ChangePlayerTurn changePlayerTurn;
    static GameData gameData;
    static GamePainter gamePainter;
    static GamePanel gamePanel;
    static MovePiece movePiece;
    static CalculateMove calculateMove;

    @BeforeAll
    static void beforeAll() {
        gameData = GameData.getInstance();
        gamePainter = new GamePainter(gameData);
        gamePanel = new GamePanel(gamePainter, gameData);
        movePiece = new MovePiece(gamePanel);
        calculateMove = new CalculateMove(gamePanel, movePiece);

        changePlayerTurn = new ChangePlayerTurn(movePiece, calculateMove);
    }

    @Test
    void testChangePlayerTurn() {
        // init:
        movePiece.setPlayerUseTurn(true);
        movePiece.setPlayerTurnColor(Color.BLACK);
        changePlayerTurn.calculateMove.gameBoard.pieces.add(new Piece(3, 3, Color.BLACK));
        changePlayerTurn.calculateMove.gameBoard.updateBoard();

        changePlayerTurn.changePlayerTurn();

        Color answer = movePiece.getPlayerTurnColor();
        Color expected = Color.WHITE;

        assertEquals(expected, answer);
    }
}