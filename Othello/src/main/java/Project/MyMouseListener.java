package Project;

import OthelloGraphic.GamePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {

    GamePanel gamePanel;
    CalculateMove calculateMove;
    MovePiece movePiece;
    ChangePlayerTurn changePlayerTurn;

    public MyMouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        // set pieces Location At Start:
        movePiece.setXNewPiece(mouseEvent.getX() /
                (483 / 8));
        movePiece.setYNewPiece(mouseEvent.getY() /
                (445 / 8));

        if (!calculateMove.isMoveValid())
            return;

        if (!calculateMove.isBoardPartEmpty())
            return;

        movePiece.movePiece();
        changePlayerTurn.changePlayerTurn();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public CalculateMove getCalculateMove() {
        return calculateMove;
    }

    public void setCalculateMove(CalculateMove calculateMove) {
        this.calculateMove = calculateMove;
    }

    public MovePiece getMovePiece() {
        return movePiece;
    }

    public void setMovePiece(MovePiece movePiece) {
        this.movePiece = movePiece;
    }

    public ChangePlayerTurn getChangePlayerTurn() {
        return changePlayerTurn;
    }

    public void setChangePlayerTurn(ChangePlayerTurn changePlayerTurn) {
        this.changePlayerTurn = changePlayerTurn;
    }
}
