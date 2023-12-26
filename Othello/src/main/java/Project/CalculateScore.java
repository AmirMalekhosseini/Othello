package Project;

import OthelloGraphic.Piece;

import java.awt.*;

public class CalculateScore {

    protected Board gameBoard;
    private String gameEndStr = "";
    private int p1Score;
    private int p2Score;

    public CalculateScore(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String calculateScore() {

        p1Score = 0;
        p2Score = 0;
        for (Piece piece : gameBoard.pieces) {
            if (piece.getColor() == Color.BLACK) {
                p1Score++;
            } else if (piece.getColor() == Color.WHITE) {
                p2Score++;
            }
        }
        if (p1Score > p2Score)
            gameEndStr = "Winner: Player 1";
        else if (p2Score > p1Score)
            gameEndStr = "Winner: Player 2";
        else
            gameEndStr = "Tie";
        return gameEndStr;
    }

    public String getGameEndStr() {
        return gameEndStr;
    }

    public void setGameEndStr(String gameEndStr) {
        this.gameEndStr = gameEndStr;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }
}
