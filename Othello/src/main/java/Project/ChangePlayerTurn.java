package Project;

import java.awt.*;

public class ChangePlayerTurn {

    protected MovePiece movePiece;
    protected CalculateMove calculateMove;

    public ChangePlayerTurn(MovePiece movePiece, CalculateMove calculateMove) {
        this.movePiece = movePiece;
        this.calculateMove = calculateMove;
    }

    public void changePlayerTurn() {
        if (movePiece.isPlayerUseTurn()) {
            if (movePiece.getPlayerTurnColor() == Color.BLACK) {
                movePiece.setPlayerTurnColor(Color.WHITE);
                if (calculateMove.isPlayerHasMove(Color.WHITE)) {
                    movePiece.setPlayerTurnColor(Color.BLACK);
                }
            } else if (movePiece.getPlayerTurnColor() == Color.WHITE) {
                movePiece.setPlayerTurnColor(Color.BLACK);
                if (calculateMove.isPlayerHasMove(Color.BLACK)) {
                    movePiece.setPlayerTurnColor(Color.WHITE);
                }
            }
        }
    }
}
