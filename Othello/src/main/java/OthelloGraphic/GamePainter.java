package OthelloGraphic;

import Project.CalculateScore;
import Project.GameData;

import java.awt.*;

public class GamePainter implements Painter {
    protected GameData gameData;
    protected GamePanel gamePanel;
    protected CalculateScore calculateScore;

    public GamePainter(GameData gameData) {
        this.gameData = gameData;
    }

    public void addGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void paintLine(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i <= gameData.getGameRow(); i++) {
            // ToDO: make a method for draw line?
            int y1Line1 = i * gameData.getGamePanelHeight() / gameData.getGameRow();
            int x2Line1 = gameData.getGamePanelWidth();
            int y2Line1 = i * gameData.getGamePanelHeight() / gameData.getGameRow();
            graphics.drawLine(0, y1Line1, x2Line1, y2Line1);

            int x1Line2 = i * gameData.getGamePanelWidth() / gameData.getGameCol();
            int x2Line2 = i * gameData.getGamePanelWidth() / gameData.getGameRow();
            int y2Line2 = gameData.getGamePanelHeight();
            graphics.drawLine(x1Line2, 0, x2Line2, y2Line2);
        }

    }

    @Override
    public void paintPiece(Graphics graphics) {
        for (Piece piece : gamePanel.getBoard().pieces) {
            int x = gamePanel.calculatePieceLocation.calculateX(piece);
            int y = gamePanel.calculatePieceLocation.calculateY(piece);
            if (piece.getColor() == Color.BLACK) {
                graphics.setColor(Color.BLACK);
            } else if (piece.getColor() == Color.WHITE) {
                graphics.setColor(Color.WHITE);
            }
            graphics.drawOval(x, y, gameData.getPieceSize(), gameData.getPieceSize());
            graphics.fillOval(x, y, gameData.getPieceSize(), gameData.getPieceSize());
        }
        graphics.setColor(Color.WHITE);
    }

    @Override
    public void paintTurn(Graphics graphics) {
        if (gamePanel.movePiece.getPlayerTurnColor() == Color.BLACK) {
            graphics.drawString("Player Turn: Black", 5, gameData.getGamePanelHeight() + 15);
        } else if (gamePanel.movePiece.getPlayerTurnColor() == Color.WHITE) {
            graphics.drawString("Player Turn: White", 0, gameData.getGamePanelHeight() + 15);
        }
    }

    @Override
    public void paintScore(Graphics graphics) {
        if (calculateScore != null) {
            graphics.drawString(calculateScore.calculateScore(), 0, gameData.getGamePanelHeight() + 15);
        }
    }
}

