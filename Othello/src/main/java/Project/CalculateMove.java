package Project;

import OthelloGraphic.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class CalculateMove {

    protected GamePanel gamePanel;
    protected MovePiece movePiece;
    protected Board gameBoard;
    private boolean isWhiteUserHasMove;
    private boolean isBlackUserHasMove = true;

    int[] dx = {1, 1, -1, -1, 0, 0, 1, -1};
    int[] dy = {-1, 1, 1, -1, 1, -1, 0, 0};

    public CalculateMove(GamePanel gamePanel, MovePiece movePiece) {
        this.gamePanel = gamePanel;
        this.movePiece = movePiece;
        this.gameBoard = gamePanel.getBoard();
    }

    public boolean isMoveValid() {
        if (movePiece.getXNewPiece() >= gamePanel.getGameData().getGameRow() ||
                movePiece.getYNewPiece() >= gamePanel.getGameData().getGameRow()) {
            return false;
        }
        return true;
    }

    public boolean isPlayerHasMove(Color playerColor) {
        for (int i = 0; i < gamePanel.getGameData().getGameRow(); i++)
            for (int j = 0; j < gamePanel.getGameData().getGameCol(); j++) {
                if (gameBoard.board[i][j] != null) {
                    continue;
                }
                boolean doesPieceFlip = false;
                mainLoop:
                for (int k = 0; k < dx.length; k++) {
                    gameBoard.flipRow = new ArrayList<>();// new flipRow ArrayList
                    for (int l = 1; l <= Math.max(gamePanel.getGameData().getGameRow(), gamePanel.getGameData().getGameCol()); l++) {
                        int nextPieceX = i + l * dx[k];
                        int nextPieceY = j + l * dy[k];
                        if (nextPieceX >= gamePanel.getGameData().getGameCol() ||
                                nextPieceX < 0 ||
                                nextPieceY >= gamePanel.getGameData().getGameRow() ||
                                nextPieceY < 0 ||
                                gameBoard.board[nextPieceX][nextPieceY] == null)
                            continue mainLoop;
                        if (gameBoard.board[nextPieceX][nextPieceY].getColor() == playerColor)
                            break;
                        gameBoard.flipRow.add(gameBoard.board[nextPieceX][nextPieceY]);
                    }
                    doesPieceFlip = !gameBoard.flipRow.isEmpty();
                }
                if (doesPieceFlip) {
                    return false;
                }
            }
        return true;
    }

    public boolean isBoardPartEmpty() {
        return gameBoard.board[movePiece.getXNewPiece()][movePiece.getYNewPiece()] == null;
    }

    public boolean isWhiteUserHasMove() {
        return isWhiteUserHasMove;
    }

    public void setWhiteUserHasMove(boolean whiteUserHasMove) {
        isWhiteUserHasMove = whiteUserHasMove;
    }

    public boolean isBlackUserHasMove() {
        return isBlackUserHasMove;
    }

    public void setBlackUserHasMove(boolean blackUserHasMove) {
        isBlackUserHasMove = blackUserHasMove;
    }
}
