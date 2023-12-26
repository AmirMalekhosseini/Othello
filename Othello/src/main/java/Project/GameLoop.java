package Project;

import OthelloGraphic.Game;
import OthelloGraphic.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop {

    protected GameFrame gameFrame;
    protected MovePiece movePiece;
    protected CalculateMove calculateMove;
    protected ChangePlayerTurn changePlayerTurn;
    protected CalculateScore calculateScore;

    public GameLoop(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        init();
    }

    private void init() {
        movePiece = new MovePiece(gameFrame.getGamePanel());
        calculateMove = new CalculateMove(gameFrame.getGamePanel(),movePiece);
        changePlayerTurn = new ChangePlayerTurn(movePiece,calculateMove);
        calculateScore = new CalculateScore(gameFrame.getGamePanel().getBoard());
        gameFrame.getGamePanel().setMovePiece(movePiece);
        gameFrame.getGamePanel().addCalculateMove(calculateMove);
        gameFrame.getGamePanel().setCalculateScore(calculateScore);
        gameFrame.getGamePanel().getMouseListener().setMovePiece(movePiece);
        gameFrame.getGamePanel().getMouseListener().setCalculateMove(calculateMove);
        gameFrame.getGamePanel().getMouseListener().setChangePlayerTurn(changePlayerTurn);

        timer();
    }

    private void timer() {

        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.getGamePanel().getBoard().updateBoard();
                gameFrame.getGamePanel().repaint();

                gameFrame.revalidate();
                gameFrame.getGamePanel().setFocusable(true);
                gameFrame.getGamePanel().requestFocus();
                gameFrame.getGamePanel().requestFocusInWindow();

                if (gameFrame.getGamePanel().getGameData().isGameFinished()) {
                    ((Timer)e.getSource()).stop();
                    Game newGame = new Game();
                }

            }
        });
        timer.start();
        timer.setRepeats(true);
    }

}
