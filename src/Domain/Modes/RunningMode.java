package Domain.Modes;

import Domain.Functionalities.GameStatueControl;
import Domain.Objects.*;
import Domain.Statistics.GameConfiguration;
import Domain.TimerBased.CollisionHandler;
import Domain.TimerBased.MovementHandler;
import Domain.TimerBased.ObjectCreationHandler;
import Domain.TimerBased.ShooterHandler;
import Domain.Useful.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class RunningMode {
    public static int screenHeight = 100;//for testing
    public static int screenWidth = 100;
    private ObjectListener frameListener;

    private ArrayList<GameObject> frameObjects;
    CopyOnWriteArrayList<GameObject> frameObjects2=new CopyOnWriteArrayList<>();


    private HashMap<String, HashMap<String, Integer>> objectsToBeProduced = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> ammunition = new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    private Timer timerObjectCreation;
    private Timer timerMoveAndCollision;
    private Timer timerClock;
    private TimerTask createObjectTask;
    private TimerTask moveAndCollideTask;
    private TimerTask clockTask;
    public ObjectCreationHandler objectCreationHandler; //static?
    ShooterHandler shooterHandler;
    public double clock;


    private int refreshRate;

    public RunningMode(ObjectListener frameListener) {
        setFrameListener(frameListener);
        frameObjects = new ArrayList<>();
    }


    public void startGame() {
        clock=100.00;
        shooterHandler=new ShooterHandler(frameListener);
        Shooter shooter=shooterHandler.createShooter();
        frameObjects2.add(shooter);

        objectCreationHandler = new ObjectCreationHandler(frameObjects2, frameListener);
        movementHandler = new MovementHandler(frameObjects2, frameListener);
        collisionHandler = new CollisionHandler(frameObjects2, frameListener);
        timerObjectCreation=new Timer();
        timerMoveAndCollision=new Timer();
        timerClock=new Timer();

        /*GameObject object=new Gamma_Molecule(new Position(250,0));
        frameObjects2.add(object);
        frameListener.onCreate(object);


        GameObject object2=new Alpha_Atom(new Position(500,500),10);
        frameObjects2.add(object2);
        frameListener.onCreate(object2);

        GameObject object3=new Alpha_Blocker(new Position(700,50));
        frameObjects2.add(object3);
        frameListener.onCreate(object3);*/




        refreshRate = 10;
        int creationTime = setCreationTime();
        createObjectTask = createObject();
        moveAndCollideTask = moveAndCollide();
        clockTask=clock();
        timerObjectCreation.scheduleAtFixedRate(createObjectTask,10,creationTime);
        timerMoveAndCollision.scheduleAtFixedRate(moveAndCollideTask,20,10);
        timerClock.scheduleAtFixedRate(clockTask,0,100);

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


    private TimerTask clock() {

        return new TimerTask() {
            @Override
            public void run() {

                clock=clock-0.1;
                GameConfiguration.getInstance().setTime(clock);
                if(GameStatueControl.getInstance().isGameEnded()){
                    endGame();
                }
            }
        };
    }

    public void pauseGame(){
        createObjectTask.cancel();
        moveAndCollideTask.cancel();
        clockTask.cancel();
        timerObjectCreation.cancel();
        timerMoveAndCollision.cancel();
        timerClock.cancel();
        GameStatueControl.getInstance().setPaused();
    }
    public void resumeGame(){
        createObjectTask = createObject();
        moveAndCollideTask = moveAndCollide();
        clockTask=clock();
        timerObjectCreation=new Timer();
        timerMoveAndCollision=new Timer();
        timerClock=new Timer();
        timerObjectCreation.scheduleAtFixedRate(createObjectTask,10,1000);
        timerMoveAndCollision.scheduleAtFixedRate(moveAndCollideTask,20,10);
        timerClock.scheduleAtFixedRate(clockTask,0,100);
        GameStatueControl.getInstance().setResumed();
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
