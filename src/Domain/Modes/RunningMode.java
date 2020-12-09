package Domain.Modes;

import Domain.Functionalities.GameStatueControl;
import Domain.Objects.GameObject;
import Domain.Objects.ObjectListener;
import Domain.Statistics.GameConfiguration;
import Domain.TimerBased.CollisionHandler;
import Domain.TimerBased.MovementHandler;
import Domain.TimerBased.ObjectCreationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class RunningMode {
    public static int screenHeight = 100;//for testing
    public static int screenWidth = 100;
    private ObjectListener frameListener;

    private ArrayList<GameObject> frameObjects;

    private HashMap<String, HashMap<String, Integer>> objectsToBeProduced = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> ammunition = new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    private Timer timerObjectCreation;
    private Timer timerMoveAndCollision;
    public static ObjectCreationHandler objectCreationHandler;

    private int refreshRate;

    public RunningMode(ObjectListener frameListener) {
        setFrameListener(frameListener);
        frameObjects = new ArrayList<>();
    }

    public void startGame() {
        objectCreationHandler = new ObjectCreationHandler(frameObjects, frameListener);
        movementHandler = new MovementHandler(frameObjects, frameListener);
        collisionHandler = new CollisionHandler(frameObjects, frameListener);
        timerObjectCreation=new Timer();
        timerMoveAndCollision=new Timer();

        refreshRate = 10;
        int creationTime = setCreationTime();
        TimerTask timerTask1 = createObject();
        TimerTask timerTask2 = moveAndCollide();
        timerObjectCreation.scheduleAtFixedRate(timerTask1,10,creationTime);
        timerMoveAndCollision.scheduleAtFixedRate(timerTask2,0,refreshRate);
    }

    public void setFrameListener(ObjectListener frameListener) {
        this.frameListener = frameListener;
    }

    private TimerTask moveAndCollide() {

        return new TimerTask() {
            @Override
            public void run() {
                movementHandler.move();
                collisionHandler.collisionDetect();
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }

    private TimerTask createObject() {

        return new TimerTask() {
            @Override
            public void run() {

                objectCreationHandler.createRandomFallingObject();
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }

    private void endGame(){
        timerObjectCreation.cancel();
        timerMoveAndCollision.cancel();
        //GameOver()
    }

    private int setCreationTime() {
        int time = 0;
        switch (GameConfiguration.getInstance().getData().getDifficulty()) {
            case HARD:
                time = 250;
                break;
            case NORMAL:
                time = 500;
                break;
            case EASY:
                time = 1000;
                break;
        }
        return time;
    }

}
