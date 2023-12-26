package OthelloGraphic;

import Project.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected MyMouseListener mouseListener;
    protected Board board;
    protected Painter painter;
    protected GameData gameData;
    protected MovePiece movePiece;
    protected CalculatePieceLocation calculatePieceLocation;
    protected CalculateScore calculateScore;
    protected CalculateMove calculateMove;

    public GamePanel(GamePainter painter, GameData gameData) {
        this.painter = painter;
        this.gameData = gameData;
        init();
    }

    public void addCalculateMove(CalculateMove calculateMove) {
        this.calculateMove = calculateMove;
    }

    private void init() {
        mouseListener = new MyMouseListener(this);
        this.addMouseListener(mouseListener);
        board = new Board(this);
        calculatePieceLocation = new CalculatePieceLocation(this);
    }

    public MyMouseListener getMouseListener() {
        return mouseListener;
    }

    public void setMouseListener(MyMouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public CalculatePieceLocation getCalculatePieceLocation() {
        return calculatePieceLocation;
    }

    public void setCalculatePieceLocation(CalculatePieceLocation calculatePieceLocation) {
        this.calculatePieceLocation = calculatePieceLocation;
    }

    public MovePiece getMovePiece() {
        return movePiece;
    }

    public void setMovePiece(MovePiece movePiece) {
        this.movePiece = movePiece;
    }

    public CalculateScore getCalculateScore() {
        return calculateScore;
    }

    public void setCalculateScore(CalculateScore calculateScore) {
        this.calculateScore = calculateScore;
    }

    public CalculateMove getCalculateMove() {
        return calculateMove;
    }

    public void setCalculateMove(CalculateMove calculateMove) {
        this.calculateMove = calculateMove;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(new Color(0, 106, 65));

        painter.paintTurn(graphics);

        // Draw Lines:
        painter.paintLine(graphics);

        // Draw Pieces:
        painter.paintPiece(graphics);

    }
}
