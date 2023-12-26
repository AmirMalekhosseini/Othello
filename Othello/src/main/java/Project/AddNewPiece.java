package Project;

import OthelloGraphic.Piece;
import java.awt.*;
public class AddNewPiece {

    public AddNewPiece(Board gameBoard, int XNewPiece, int YNewPiece, Color playerTurnColor) {
        gameBoard.pieces.add(new Piece(XNewPiece, YNewPiece, playerTurnColor));
    }

}
