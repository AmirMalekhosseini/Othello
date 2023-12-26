package OthelloGraphic;

import Project.GameLoop;

public class Game {


    public Game() {
        GameFrame gameFrame = new GameFrame();
        GameLoop gameLoop = new GameLoop(gameFrame);
    }

}
