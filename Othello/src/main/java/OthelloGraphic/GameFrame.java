package OthelloGraphic;

import Project.GameData;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    protected GamePanel gamePanel;
    protected GamePainter painter;
    protected GameData gameData;
    private int screenWidth;
    private int screenHeight;
    private int windowWidth;
    private int windowHeight;

    public GameFrame() {
        init();
    }

    private void init() {
        gameData = GameData.getInstance();
        painter = new GamePainter(gameData);
        gamePanel = new GamePanel(painter, gameData);
        painter.addGamePanel(gamePanel);
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        windowWidth = gameData.getGameFrameWidth();
        windowHeight = gameData.getGameFrameHeight();
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(windowWidth, windowHeight));
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
        this.setVisible(true);

        this.setContentPane(gamePanel);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
}
