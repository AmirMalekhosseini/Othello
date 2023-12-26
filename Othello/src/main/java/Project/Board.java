package Project;

import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    public ArrayList<Piece> pieces = new ArrayList<>();
    public ArrayList<Piece> flipRow = new ArrayList<>();
    GamePanel gamePanel;
    Piece[][] board;

    public Board(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        pieces.add(new Piece(3,3, Color.BLACK));
        pieces.add(new Piece(4,4, Color.BLACK));
        pieces.add(new Piece(3,4, Color.WHITE));
        pieces.add(new Piece(4,3, Color.WHITE));
    }

    public void updateBoard() {
        board = getCellState();
    }

    public Piece[][] getCellState() {
        Piece[][] board = new Piece[gamePanel.getGameData().getGameRow()][gamePanel.getGameData().getGameCol()];
        for (Piece piece : this.pieces) {
            board[piece.getX()][piece.getY()] = piece;
        }
        return board;
    }

}
