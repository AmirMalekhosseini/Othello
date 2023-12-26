package Project;

import OthelloGraphic.GamePanel;
import OthelloGraphic.Piece;

public class CalculatePieceLocation {

    GamePanel gamePanel;

    public CalculatePieceLocation(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public int calculateX(Piece piece) {
        int x = piece.getX() *
                (gamePanel.getGameData().getGamePanelWidth() / gamePanel.getGameData().getGameCol())
                + (gamePanel.getGameData().getGamePanelWidth() / gamePanel.getGameData().getGameCol()) /
                2 - gamePanel.getGameData().getPieceSize() / 2;
        return x;
    }

    public int calculateY(Piece piece) {
        int y = piece.getY() *
                (gamePanel.getGameData().getGamePanelHeight() / gamePanel.getGameData().getGameRow())
                + (gamePanel.getGameData().getGamePanelHeight() / gamePanel.getGameData().getGameRow()) /
                2 - gamePanel.getGameData().getPieceSize() / 2;
        return y;
    }

}
