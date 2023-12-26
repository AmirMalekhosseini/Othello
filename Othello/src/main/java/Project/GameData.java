package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameData {

    private static GameData instance = null;

    private Properties properties = new Properties();
    private FileInputStream inputStream;

    private final int gamePanelHeight;
    private final int gameFrameHeight;
    private final int gamePanelWidth;
    private final int gameFrameWidth;
    private final int gameRow;
    private final int gameCol;
    private final int pieceSize;

    private boolean isGameFinished;

    private GameData() {
        try {
            inputStream = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gamePanelHeight = Integer.parseInt(properties.getProperty("gamePanelHeight"));
        gameFrameHeight = Integer.parseInt(properties.getProperty("gameFrameHeight"));
        gamePanelWidth = Integer.parseInt(properties.getProperty("gamePanelWidth"));
        gameFrameWidth = Integer.parseInt(properties.getProperty("gameFrameWidth"));
        gameRow = Integer.parseInt(properties.getProperty("gameRow"));
        gameCol = Integer.parseInt(properties.getProperty("gameCol"));
        pieceSize = Integer.parseInt(properties.getProperty("pieceSize"));
    }

    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }

    public int getGamePanelHeight() {
        return gamePanelHeight;
    }

    public int getGamePanelWidth() {
        return gamePanelWidth;
    }

    public int getGameRow() {
        return gameRow;
    }

    public int getGameCol() {
        return gameCol;
    }

    public int getPieceSize() {
        return pieceSize;
    }

    public int getGameFrameHeight() {
        return gameFrameHeight;
    }

    public int getGameFrameWidth() {
        return gameFrameWidth;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public FileInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(FileInputStream inputStream) {
        this.inputStream = inputStream;
    }
}
