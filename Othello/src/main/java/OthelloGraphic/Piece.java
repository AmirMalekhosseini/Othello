package OthelloGraphic;

import java.awt.*;

public class Piece {

    private boolean doesFlip = false;
    private final int x;
    private final int y;
    Color color;

    public Piece(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDoesFlip() {
        return doesFlip;
    }

    public void setDoesFlip(boolean doesFlip) {
        this.doesFlip = doesFlip;
    }
}
