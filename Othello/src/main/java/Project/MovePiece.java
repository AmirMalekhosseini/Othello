package Project;

import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;

import java.awt.*;
import java.util.ArrayList;

public class MovePiece {

    protected GamePanel gamePanel;
    protected Board gameBoard;

    private int XNewPiece;
    private int YNewPiece;
    private boolean doesFlip = false;
    private boolean isPlayerUseTurn = false;

    int[] dx = {1, 1, -1, -1, 0, 0, 1, -1};
    int[] dy = {-1, 1, 1, -1, 1, -1, 0, 0};

    private Color playerTurnColor = Color.BLACK;

    public MovePiece(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gameBoard = gamePanel.getBoard();
    }

    public void movePiece() {

        boolean doesFlip = false;

        // Unflip all pieces:
        for (Piece piece : gamePanel.getBoard().pieces) {
            piece.setDoesFlip(false);
        }

        mainLoop:
        for (int k = 0; k < dx.length; k++) {
            gamePanel.getBoard().flipRow = new ArrayList<>();
            for (int i = 1; i <= Math.max(gamePanel.getGameData().getGameRow(), gamePanel.getGameData().getGameCol()); i++) {
                int changedPieceX = XNewPiece + i * dx[k];
                int changedPieceY = YNewPiece + i * dy[k];
                if (changedPieceX >= gamePanel.getGameData().getGameCol() ||
                        changedPieceX < 0 ||
                        changedPieceY >= gamePanel.getGameData().getGameRow() ||
                        changedPieceY < 0 ||
                        gameBoard.board[changedPieceX][changedPieceY] == null)
                    continue mainLoop;
                if (gameBoard.board[changedPieceX][changedPieceY].getColor() == playerTurnColor) {
                    //                System.out.println(gameBoard.board[changedPieceX][changedPieceY].getColor());
                    break;
                }
                gameBoard.flipRow.add(gameBoard.board[changedPieceX][changedPieceY]);
            }
            for (Piece piece : gameBoard.flipRow) {
                piece.setDoesFlip(true);
                piece.setColor(playerTurnColor);
                doesFlip = true;
            }
        }
            if (doesFlip) {
                AddNewPiece add = new AddNewPiece(gameBoard, XNewPiece, YNewPiece, playerTurnColor);
                isPlayerUseTurn = true;
            }
            else
                isPlayerUseTurn = false;
    }

    public int getXNewPiece() {
        return XNewPiece;
    }

    public void setXNewPiece(int XNewPiece) {
        this.XNewPiece = XNewPiece;
    }

    public int getYNewPiece() {
        return YNewPiece;
    }

    public void setYNewPiece(int YNewPiece) {
        this.YNewPiece = YNewPiece;
    }

    public Color getPlayerTurnColor() {
        return playerTurnColor;
    }

    public void setPlayerTurnColor(Color playerTurnColor) {
        this.playerTurnColor = playerTurnColor;
    }

    public boolean isDoesFlip() {
        return doesFlip;
    }

    public void setDoesFlip(boolean doesFlip) {
        this.doesFlip = doesFlip;
    }

    public boolean isPlayerUseTurn() {
        return isPlayerUseTurn;
    }

    public void setPlayerUseTurn(boolean playerUseTurn) {
        isPlayerUseTurn = playerUseTurn;
    }

}
