package OthelloGraphic;

import java.awt.*;

public interface Painter {
    void paintLine(Graphics graphics);

    void paintPiece(Graphics graphics);
    void paintTurn(Graphics graphics);

    void paintScore(Graphics graphics);
}
